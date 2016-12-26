from datetime import datetime, timedelta
import json
import requests 
import csv_manager
import subprocess


class APIfinder(): 

    def __init__(self):
        self.counter = csv_manager.read_last_line()
        self.key_substring = "api/gbs.mm.com"
        self.incident_key = str(self.counter) + self.key_substring
        self.payload = {
            "service_key": "2abec0bf916747579ead0b291b64019e",
            "incident_key": self.incident_key,
            "event_type": "trigger",
            "description": "API service on gbs.mediamath.com is unreachable",
            "client": "API service monitoring",
            "client_url": "https://gbs.mediamath.com/"
        }
        self.json_payload = json.dumps(self.payload)

    def run(self):
        try:
            response = requests.get('https://gbs.mediamath.com/', timeout=30.00, headers={'Authorization': 'Token token= "a_test_token_that_is_long_enough"'})
            # logic for responding to a code that is not 401:
            if response.status_code != 401:
                print "response code != 401;"
                self.alert()
                self.i_key()
            else:
                # needs a time_stamp
                print str(response.status_code) + " :  " + response.text + " :  " + str(datetime.utcnow())
                # change permissions for logwriter.sh and call it here:
                subprocess.call("./logwriter.sh", shell=True)
        except:

            print "API service at http://gbs.mediamath.com appears to be down: sending alert..."  +  " :  "  +  str(datetime.utcnow())
            self.alert()
            self.i_key()




    def alert(self):
        response = requests.post("https://events.pagerduty.com/generic/2010-04-15/create_event.json", data=self.json_payload)
        # print response.text
        print "Response code for alert POST: " + str(response.status_code)




    def i_key(self):
        self.counter += 1
        # print self.counter
        self.incident_key = str(self.counter) + self.key_substring
        self.payload["incident_key"] = self.incident_key
        csv_manager.write_log(self.counter, self.incident_key)







af = APIfinder() 
af.run() 












