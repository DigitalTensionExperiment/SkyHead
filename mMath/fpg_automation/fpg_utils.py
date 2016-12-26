import psycopg2
import ipdb 
import sys 
import parameters 


def connection_maker(): 
	conn = None 
	cursor = None 
	try: 
		conn = psycopg2.connect(host='ewr-t1qa-n1.mediamath.com', database='adama_qa', port=5432, user='adama') 
		print "Connection made successfully..." 
		string = "SELECT count(*) FROM organizations;"
		cursor = conn.cursor() 
		cursor.execute(string) 
		x = cursor.fetchone()[0]
		print x, type(x)
	except psycopg2.DatabaseError, e:
	    if conn:
	        conn.rollback()
	    print 'Error %s' % e    
	    sys.exit(1) 
	return cursor



#####################################################



def make_creative(cursor,atomic_creative_id):  
	cursor.execute('INSERT INTO creatives (atomic_creative_id,tag,tag_type) VALUES (%s,%s,%s);',(atomic_creative_id,parameters.TAG,parameters.TAG_TYPE)) 
	print "Creative has been inserted..." 


def make_atomic_creative(cursor,advertiser_id,concept_id): 	
	#	make creative 
	cursor.execute('INSERT INTO atomic_creatives (advertiser_id,concept_id,name,width,height,external_identifier,tpas_ad_tag_name) VALUES (%s,%s,%s,%s,%s,%s,%s);',(advertiser_id,concept_id,parameters.ATOMIC_CREATIVE_NAME,parameters.WIDTH,parameters.HEIGHT,parameters.EXTERNAL_IDENTIFIER, parameters.TPAS_AD_TAG_NAME)) 
	print "Atomic-reative has been inserted..." 
	#	use input to get atomic_creative_id 
	select_statement = "SELECT id FROM atomic_creatives WHERE name='%s';" % parameters.ATOMIC_CREATIVE_NAME
	cursor.execute(select_statement) 
	atomic_creative_id = cursor.fetchall()[0] 
	print atomic_creative_id, type(atomic_creative_id)
	make_creative(cursor,atomic_creative_id)
	#	return atomic_creative_id 
	

def make_concept( cursor,advertiser_id ):  
	#	make concept 
	cursor.execute('INSERT INTO concepts (advertiser_id,name) VALUES (%s,%s);',(advertiser_id,parameters.CONCEPT_NAME)) 
	print "Concept has been inserted..." 
	#	use input to get concept_id
	select_statement = "SELECT id FROM concepts WHERE name='%s';" % parameters.CONCEPT_NAME
	cursor.execute(select_statement) 
	concept_id = cursor.fetchall()[0] 
	make_atomic_creative(cursor,advertiser_id,concept_id)
	#	return concept_id 
	make_campaign(cursor,advertiser_id,concept_id)
	#return concept_id


def make_strategy_concept( cursor, concept_id, strategy_id ): 
	#	make strategy_concept 
	# cursor.execute('INSERT INTO strategy_concepts (strategy_id,concept_id) VALUES (%s,%s);',(strategy_id,concept_id)) 
	# print "Strategy_concept has been inserted..." 
	#	use inputs to get strategy_concept_id
	select_statement = "SELECT id FROM strategy_concepts WHERE strategy_id=%s;" % strategy_id
	cursor.execute(select_statement) 
	strategy_concept_id = cursor.fetchall()[0] 
	print "Strategy_concept concept has been generated..."
	print strategy_concept_id, type(strategy_concept_id)
	# return strategy_concept_id
	

def make_strategy(cursor,campaign_id,concept_id):
	#	make strategy 
	cursor.execute('INSERT INTO strategies (name, campaign_id, start_date, end_date, goal_type, budget, pacing_amount, max_bid, type, currency_code, zone_name) VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s);',(parameters.STRATEGY_NAME,campaign_id,parameters.START_DATE,parameters.END_DATE,parameters.GOAL_TYPE,parameters.STRATEGY_BUDGET,parameters.PACING_AMOUNT,parameters.MAX_BID,parameters.TYPE,parameters.CURRENCY_CODE,parameters.ZONE_NAME)) 
	print "Strategy has been inserted..." 
	#	use inputs to get strategy_id
	select_statement = "SELECT id FROM strategies WHERE name='%s';" % parameters.STRATEGY_NAME
	cursor.execute(select_statement) 
	strategy_id = cursor.fetchall()[0] 
	make_strategy_concept(cursor,strategy_id,concept_id)
	

# create campaign( advertiser_id,concept_id ) 
def make_campaign(cursor,advertiser_id,concept_id): 
	cursor.execute('INSERT INTO campaigns (advertiser_id,status,name,ad_server_id,start_date,end_date,goal_type,total_budget,service_type,currency_code) VALUES (%s,true,%s,%s,%s,%s,%s,%s,%s,%s);',(advertiser_id,parameters.CAMPAIGN_NAME,parameters.AD_SERVER_ID,parameters.START_DATE,parameters.END_DATE,parameters.GOAL_TYPE,parameters.CAMPAIGN_BUDGET,parameters.SERVICE_TYPE,parameters.CURRENCY_CODE)) 
	print "Campaign has been inserted..." 
	#	use inputs to get campaign_id 
	select_statement = "SELECT id FROM campaigns WHERE name='%s';" % parameters.CAMPAIGN_NAME 
	cursor.execute(select_statement) 
	campaign_id = cursor.fetchall()[0] 
	print campaign_id, type(campaign_id) 
	make_strategy(cursor,campaign_id,concept_id)
	#	strategy( campaign_id,concept_id ) 
	


def make_advertiser(cursor,agency_id): 
	cursor.execute('INSERT INTO advertisers (agency_id,name,vertical_id,ad_server_id,domain) VALUES (%s,%s,%s,%s,%s);',(agency_id,parameters.ADVERTISER_NAME,parameters.VERTICAL_ID,parameters.AD_SERVER_ID,parameters.ADV_DOMAIN)) 
	print "Advertiser has been inserted..." 
	#	use inputs to get advertiser_id 
	select_statement = "SELECT id FROM advertisers WHERE name='%s' ;" % parameters.ADVERTISER_NAME
	cursor.execute(select_statement) 
	advertiser_id = cursor.fetchall()[0] 
	print advertiser_id, type(advertiser_id) 
	concept_id = make_concept(cursor, advertiser_id) 
	#make_campaign(cursor,advertiser_id,concept_id) 
	


def make_agency( cursor,organization_id ): 
	cursor.execute('INSERT INTO agencies (organization_id,name) VALUES (%s,%s);',(organization_id,parameters.AGENCY_NAME)) 
	print "Agency has been inserted..." 
	# select_statement = "SELECT id FROM agencies WHERE organization_id=%s ;" % organization_id 
	select_statement = "SELECT id FROM agencies WHERE name='%s' ;" % parameters.AGENCY_NAME 
	cursor.execute(select_statement) 
	agency_id = cursor.fetchall()[0] 
	print agency_id, type(agency_id)
	make_advertiser(cursor, agency_id)

	

def make_organization( cursor ): 
	cursor.execute('INSERT INTO organizations (name,status,contact_name,address_1,city,state,zip,phone,mm_contact_name,allow_x_agency_pixels) VALUES (%s,true,%s,%s,%s,%s,%s,%s,%s,true);',(parameters.ORG_NAME,parameters.ORG_CONTACT_NAME,parameters.ADD1,parameters.CITY,parameters.STATE,parameters.ZIP,parameters.PHONE,parameters.MM_CONTACT_NAME)) 
	print "Organization has been inserted..." 
	#select_statement = "SELECT id FROM organizations WHERE id=%s ;" % id
	select_statement = "SELECT id FROM organizations WHERE name='%s' ;" % parameters.ORG_NAME
	cursor.execute(select_statement) 
	organization_id = cursor.fetchall()[0] 
	print organization_id, type(parameters.ORG_NAME)
	make_agency(cursor, organization_id)



# cursor.execute('INSERT INTO strategies (name, campaign_id, start_date, end_date, goal_type, budget, pacing_amount, max_bid, type, currency_code, zone_name) VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s);', (parameters.STRAT_NAME, new_campaign_id, [start_date], [end_date], [goal_type], [budget], [pacing_amount], [max_bid], [type], [currency_code], [zone_name])) 



#	campaign( concept_id, advertiser_id ) 

#####################################################

# create atomic_creative( advertiser_id, concept_id ) 





# def strategy_concepter_maker(cursor): 
# 	strategy_id = strategy_id_getter(cursor) 
# 	concept_id = concept_id_getter(cursor) 
# 	cursor.execute('INSERT INTO strategy_concepts VALUES ();',())
# 	print "Strategy_concept has been inserted..." 


# #####################################################

# def strategy_id_getter(cursor):	
# 	campaign_id = campaign_id_getter(cursor) 
# 	cursor.execute('INSERT INTO strategies VALUES ();',()) 
# 	print "Strategy has been inserted..." 


# def concept_id_getter(cursor):   
# 	advertiser_id = advertiser_id_getter(cursor) 
# 	cursor.execute('INSERT INTO concepts VALUES ();',()) 
# 	print "Strategy has been inserted..." 	


# def atomic_creative_id_getter(cursor):	
# 	advertiser_id = advertiser_id_getter(cursor) 
# 	concept_id = campaign_id_getter(cursor) 


# # create advertiser( agency_id ) 
# #	





def organization_id(cursor):
	# insert params for new org
	cursor.execute('INSERT INTO organizations (name,status,contact_name,address_1,city,state,zip,phone,mm_contact_name,allow_x_agency_pixels) VALUES (%s,true,%s,%s,%s,%s,%s,%s,%s,true);', (parameters.ORG_NAME, parameters.ORG_CONTACT_NAME, parameters.ADD1, parameters.CITY, parameters.STATE, parameters.ZIP, parameters.PHONE, parameters.MM_CONTACT)) 
	print "Org insert is complete..."  
	# retrieve the id of the org that was just created: 
	org_id = org_id_getter(cursor) 
	return org_id



# def org_id_getter(cursor): 
# 	select_statement = "SELECT id FROM organizations WHERE name='%s';" % parameters.ORG_NAME
# 	cursor.execute(select_statement) 
# 	return cursor.fetchall()[0]
	

# #####################################################


# def agency_id(cursor): 
# 	org_id = organization_id(cursor)
# 	cursor.execute('INSERT INTO agencies (organization_id,name) VALUES (%s,%s);', (org_id, parameters.AGENCY_NAME)) 
# 	print "Agency insert is complete..."  
# 	agency_id = agency_id_getter(cursor) 
# 	return agency_id



# def agency_id_getter(cursor): 
# 	select_statement = "SELECT id FROM agencies WHERE name='%s';" % parameters.AGENCY_NAME
# 	cursor.execute(select_statement) 
# 	return cursor.fetchall()[0]
	

# #####################################################



# # def advertiser_creator(cursor,new_agency_id): 
# # 	cursor.execute('INSERT INTO advertisers (agency_id,name,vertical_id,ad_server_id,domain) VALUES (%s,%s,%s,%s,'www.mediamath.com');', (new_agency_id, parameters.ADV_NAME, 11, 9)) 
# # 	print "Insert line is completed..."  


# # def advertiser_id_getter(cursor):	
# # 	select_statement = "SELECT id FROM advertisers WHERE name='%s';" % parameters.ADV_NAME
# # 	cursor.execute(select_statement) 
# # 	# result = cursor.fetchall() 
# # 	new_advertiser_id = cursor.fetchall()[0]
# # 	# print result
# # 	return new_advertiser_id 



# # def campaign_creator(cursor,new_advertiser_id): 
# # 	cursor.execute('INSERT INTO campaigns (advertiser_id,status,name,ad_server_id,start_date,end_date,goal_type,total_budget,service_type,currency_code) VALUES (%s,true,%s,%s,%s,%s,%s,%s,%s,%s);', (new_advertiser_id,[name],[ad_server_id],[start_date],[end_date],[goal_type],[total_budget],[service_type],[currency_code])) 
# # 	print "Campaign creation has been executed..."  


# # def campaign_id_getter(cursor): 
# # 	# ... 
# # 	return new_campaign_id


# # def concept_creator(cursor,new_advertiser_id): 
# # 	cursor.execute('INSERT INTO concepts (advertiser_id,name) VALUES (%s,%s);', (new_advertiser_id,parameters.CONCEPT_NAME)) 
# # 	print "Concept creation has been executed..."  


# # def concept_id_getter(cursor): 
# # 	# ... 
# # 	return new_concept_id


# # def atomic_creative_creator(cursor,new_advertiser_id,new_concept_id): 
# # 	cursor.execute('INSERT INTO atomic_creatives (advertiser_id,concept_id,name,width,height,external_identifier,tpas_ad_tag_name) VALUES (%s,%s,%s,%s,%s,%s,%s);', (new_advertiser_id, new_concept_id,[name],[width],[height],[external_identifier],[tpas_ad_tag_name])) 
# # 	print "Atomic-creative creation has been executed..."  


# # def creative_creator(cursor,new_atomic_creative_id): 
# # 	cursor.execute('INSERT INTO creatives (atomic_creative_id,tag,tag_type) VALUES (%s,%s,%s);', (new_atomic_creative_id, [tag], [tag_type])) 
# # 	print "Creative creation has been executed..."  




# # def strategy_creator(cursor,new_campaign_id): 
# # 	cursor.execute('INSERT INTO strategies (name, campaign_id, start_date, end_date, goal_type, budget, pacing_amount, max_bid, type, currency_code, zone_name) VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s);', (parameters.STRAT_NAME, new_campaign_id, [start_date], [end_date], [goal_type], [budget], [pacing_amount], [max_bid], [type], [currency_code], [zone_name])) 
# # 	print "Strategy creation has been executed..."  


# # def strategy_id_getter(cursor): 
# # 	# ... 
# # 	return new_strategy_id 


# # def strategy_concept_creator(cursor, new_strategy_id, new_concept_id): 
# # 	cursor.execute('INSERT INTO strategy_concepts (strategy_id,concept_id) VALUES (%s,%s);', (new_strategy_id,new_concept_id)) 
# # 	print "Strategy-concept creation has been executed..."  


# # def seat_assigner(cursor,new_org_id): 
# # 	cursor.execute('INSERT INTO seats (organization_id,supply_source_id,seat_identifier,status) VALUES (%s,%s,%s,true);', (new_org_id, parameters.SUPPLY_SOURCE_ID, parameters.SEAT_ID)) 
# # 	print "Seats assignment to Org has been executed..." 
















