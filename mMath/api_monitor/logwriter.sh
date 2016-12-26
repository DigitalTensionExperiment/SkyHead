#!/bin/bash

echo "Checking for existing process log for api refresh today"
	first_log=$(curl "https://knox.mediamath.com/api/v1/process_logs?days=0&process_name=monitor_alert%25&fuzzy_match=1" -H 'Authorization: Token token="ca54a60be1e6ee759fc486552750c50f"')
	check='[]'
	if [[ $first_log == $check ]]; then
		echo "Starting logging process log for api refresh"
		bytesize=$(stat -c '%s' "/d1/csv/gbs_summary.list")
		curl -X POST -d '{"message":"api refresh was successful"}' "https://knox.mediamath.com/api/v1/process_logs?process_name=monitor_alert" -H 'Authorization: Token token="ca54a60be1e6ee759fc486552750c50f"' -H "Content-Type:application/json"
		echo "Finished logging process log for api refresh"
	else
		echo "Found a process log for api refresh today. Not sending another log"
	fi

