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


outPath = '/Users/zareen/Documents/Paperwork/daily/deployHistory/deployHistory.csv'

headers = ['key', 'URL','id','createdDate']
write = csv.writer(open(outPath, 'a'))
#write.writerow(headers)

#writerServoAPI = csv.writer(open(outfilePathServoAPI, 'w'))
#writerServoAPI.writerow(headers)
#queryServo = sys.argv[1]
#queryServoAPI = sys.argv[2]

url = urllib2.Request("https://jira.medialets.com/rest/api/2/search?jql=summary~'deploy'+order+by+createdDate+asc&maxResults=1000")
parsed_jsonServo = json.load(opener.open(url))


UIurl = 'https://jira.medialets.com/browse/'

for tickets in parsed_jsonServo['issues']:
        row = []
        fields = tickets['fields']
        status = fields['status']
        name = str(status['name'].encode('utf-8'))
        project = fields['project']
        createdDate = str(fields['created'].encode('utf-8')) [:10]
        focus = str(project['name'].encode('utf-8'))
        if focus=="QA" or focus=="Product Operations" or focus=="CHANGE_CONTROL":
            print project['name']
            row.append(str(tickets['key'].encode('utf-8')))
            row.append(UIurl + str(tickets['key']).encode('utf-8'))
            row.append(str(tickets['id'].encode('utf-8')))
            row.append(createdDate)
            row.append(name)
            write.writerow(row)
            #print str(fields['status'])
            #row.append(str(fields['status']).encode('utf-8'))



