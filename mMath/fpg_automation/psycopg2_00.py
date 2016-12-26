import psycopg2
import ipdb 
import sys
import parameters 
import fpg_utils 
from org_maker import Organization 
from agency_maker import Agency
from advertiser_maker import Advertiser 
from concept_maker import Concept
from campaign_maker import Campaign
from atomic_creative_maker import AtomicCreative 
from strategy_maker import Strategy
from strategy_concept_maker import StrategyConcept
from creative_maker import Creative


conn = None

try: 
	
	conn = psycopg2.connect(host='ewr-t1qa-n1.mediamath.com', database='adama_qa', port=5432, user='adama') 
	#host='localhost', host='ewr-apidataqa2-x1.mediamath.com', 
	#'localhost'
	print "Connection made successfully..." 
	# assemble query
	#string = "SELECT count(*) FROM organizations where status=true;"
	cursor = conn.cursor() 
	
	org = Organization(cursor)
	org.org_create() 
	print org.id 

	agency = Agency(cursor, org.id)  
	agency.agency_create() 
	print agency.id

	adv = Advertiser(cursor, agency.id)	
	adv.advertiser_create() 
	print adv.id

	concept = Concept(cursor, adv.id) 
	concept.concept_create() 
	print concept.id

	campaign = Campaign(cursor, adv.id, concept.id) 
	campaign.campaign_create()
	print campaign.id
	
	atomic = AtomicCreative(cursor, adv.id, concept.id) 
	atomic.atomic_creative_create() 
	print atomic.id

	strategy = Strategy(cursor,campaign.id,concept.id) 
	strategy.strategy_create()
	print strategy.id

	strategy_concept = StrategyConcept(cursor, strategy.id, concept.id)
	strategy_concept.strategy_concept_create() 
	#print strategy_concept.id 

	creative = Creative(cursor, atomic.id) 
	creative.creative_create() 

	# cursor.execute(select) 
	# #x = cursor.fetchone()[0]
	# y = cursor.fetchone()[1]
	# print y 
	# conn.commit()
# except: 
# 	trace = ipdb.set_trace() 
# 	#print str(trace) 
# 	print "no connection yet..." 
except psycopg2.DatabaseError, e:
    
    if conn:
        conn.rollback()
    
    print 'Error %s' % e    
    sys.exit(1) 
finally: 
	if conn: 
		print "Closing connection now..."
		conn.close()
