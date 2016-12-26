import datetime 
import urllib2
import json
import csv
#import sys
from time import sleep 
import urllib
import cookielib

jira_serverURL = "https://jira.medialets.com" 
creds = {"username": "zareen.wilhelm", "password": "srsr07310!"}
authURL = jira_serverURL + "/rest/auth/latest/session"

cj = cookielib.CookieJar()
opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(cj))
req = urllib2.Request(authURL)
req.add_data('{ "username" : "zareen.wilhelm", "password" : "srsr07310!" }')
req.add_header("Content-type", "application/json")
req.add_header("Accept", "application/json")
fp = opener.open(req)
fp.close()

outfilePath = '/Users/zareen/Documents/Paperwork/daily/today.csv'
headers = ['createdDate', 'key', 'key|URL']
write = csv.writer(open(outfilePath, 'a'))
#write.writerow(headers)

urlservo = urllib2.Request('https://jira.medialets.com/rest/api/2/search?jql=project=servo%20and%20status=open')


parse_json = json.load(opener.open(urlservo))

i = datetime.datetime.now()
#today = i.isoformat() [:10]
today = '2013-12-16'
print("Today's date is: " + today)

UIurl = 'https://jira.medialets.com/browse/'

for tickets in parse_json['issues']:
    row = []
    fields = tickets['fields']
    status = fields['status']
    name = str(status['name'].encode('utf-8'))
    link = UIurl + str(tickets['key'].encode('utf-8'))
    createdDate = str((fields['created'].encode('utf-8'))) [:10]
    if createdDate == today:
        row.append(createdDate)
        row.append(name)
        row.append(str(tickets['key'].encode('utf-8')))
        #row.append(str(status['name']).encode('utf-8'))
        row.append('[' + str(tickets['key'].encode('utf-8')) + ' | ' + link + ']')
        write.writerow(row)


urlservoapi = urllib2.Request('https://jira.medialets.com/rest/api/2/search?jql=project=servoapi%20and%20status=open')
parse_json2 = json.load(opener.open(urlservoapi))


for tickets in parse_json2['issues']:
    row = []
    fields = tickets['fields']
    status = fields['status']
    #name = str(status['name'].encode('utf-8'))
    link = UIurl + str(tickets['key'].encode('utf-8'))
    createdDate = str((fields['created'].encode('utf-8'))) [:10]
    if createdDate == today:
        row.append(createdDate)
        row.append(str(status['name'].encode('utf-8')))
        row.append(str(tickets['key'].encode('utf-8')))
        #row.append(str(status['name']).encode('utf-8'))
        row.append('[' + str(tickets['key'].encode('utf-8')) + ' | ' + link + ']')
        write.writerow(row)





