#!/bin/bash 

curl -s -c jar.txt -X POST -H "Content-Type: application/json" --data @login.json "https://servo.medialets.com/api/v1/session?api_key=special-key" > signIn.txt 
curl -s -b jar.txt "https://servo.medialets.com/api/v1/session?api_key=special-key" > session.txt
curl -s -b jar.txt "https://servo.medialets.com/api/v1/campaigns?q=run&limit=100&offset=0&api_key=special-key" > campaign.txt 
curl -s -b jar.txt "https://servo.medialets.com/api/v1/campaigns/CA-FGSJ588/placements?api_key=special-key" > placements.txt 
curl -s -b jar.txt "https://servo.medialets.com/api/v1/campaigns/CA-FGSJ588/creatives?api_key=special-key" > creatives.txt 
curl -s -b jar.txt "https://servo.medialets.com/api/v1/campaigns/CA-FGSJ588/tags?api_key=special-key" > tags.txt 
