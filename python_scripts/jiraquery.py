import urllib2
import json
import csv
#import sys
from time import sleep 
import urllib
import cookielib

jira_serverurl = "https://jira.medialets.com"
creds = { "username" : "zareen.wilhelm", "password" : "srsr07310!" }
authurl = jira_serverurl + "/rest/auth/latest/session"

# Get the authentication cookie using the REST API
cj = cookielib.CookieJar()
opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(cj))
req = urllib2.Request(authurl)
req.add_data('{ "username" : "zareen.wilhelm", "password" : "srsr07310!" }')
req.add_header("Content-type", "application/json")
req.add_header("Accept", "application/json")
fp = opener.open(req)
fp.close()


outfilePathServo = '/Users/zareen/Documents/Paperwork/unclosedServo.csv'
outfilePathServoAPI = '/Users/zareen/Documents/Paperwork/unclosedServoAPI.csv'

headers = ['key', 'URL','id','createdDate','status']

writerServo = csv.writer(open(outfilePathServo, 'w'))
writerServo.writerow(headers)

writerServoAPI = csv.writer(open(outfilePathServoAPI, 'w'))
writerServoAPI.writerow(headers)

#queryServo = sys.argv[1]
#queryServoAPI = sys.argv[2]

urlServo = urllib2.Request('https://jira.medialets.com/rest/api/2/search?jql=status!=closed%20and%20project=servo&maxResults=1000')
parsed_jsonServo = json.load(opener.open(urlServo))


UIurl = 'https://jira.medialets.com/browse/'

for servoTickets in parsed_jsonServo['issues']:
	fields = servoTickets['fields']	
	createdDate = str(fields['created'].encode('utf-8')) [:10]
	row = [] 
	row.append(str(servoTickets['key'].encode('utf-8')))
	row.append(UIurl + str(servoTickets['key']).encode('utf-8'))
	row.append(str(servoTickets['id'].encode('utf-8')))
	row.append(createdDate)
	#print str(fields['status'])
	row.append(str(fields['status']).encode('utf-8'))
	writerServo.writerow(row) 

urlServoAPI = urllib2.Request('https://jira.medialets.com/rest/api/2/search?jql=status!=closed%20and%20project=servoAPI&maxResults=1000')
parsed_jsonServoAPI = json.load(opener.open(urlServoAPI))

for servoAPItickets in parsed_jsonServoAPI['issues']:
	fields = servoAPItickets['fields']
	row = []
	row.append(str(servoAPItickets['key'].encode('utf-8')))
	row.append(UIurl + str(servoTickets['key']).encode('utf-8'))
	row.append(str(servoAPItickets['id'].encode('utf-8')))
	createdDate = str(fields['created'].encode('utf-8')) [:10]
	row.append(createdDate)
	row.append(str(fields['status']).encode('utf-8'))
	writerServoAPI.writerow(row)
