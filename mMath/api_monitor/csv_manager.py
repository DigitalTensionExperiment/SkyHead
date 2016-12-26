import csv 
import os


# function that reads and returns last counter value 
def read_last_line(): 
	current = os.path.dirname(os.path.realpath(__file__))
	out = open(current + '/incident_keys.csv','rb') 
	data = csv.reader(out) 
	data = [row for row in data] 
	total_rows = len(data) 
	last_row = data[total_rows-1] 
	out.close() 
	#print "Total rows in csv: " + str(total_rows) 
	return eval(last_row[0])


# function that takes currently used counter 
def write_log(counter, incident_key): 
	#headers 
	current = os.path.dirname(os.path.realpath(__file__)) 
	write = csv.writer(open(current + '/incident_keys.csv', 'a'))  
	write.writerow([counter, incident_key]) 
	#write.close() 

