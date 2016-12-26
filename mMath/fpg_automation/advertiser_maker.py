from concept_maker import Concept
import parameters


class Advertiser(): 


	def __init__(self, cursor, agency_id): 
		self.cursor = cursor 	
		self.agency_id = agency_id
		self.adv_name = parameters.ADVERTISER_NAME
		self.vertical_id = parameters.VERTICAL_ID
		self.ad_server_id = parameters.AD_SERVER_ID
		self.domain = parameters.ADV_DOMAIN
		

	def message_constructor(self): 
		message = 'INSERT INTO advertisers (agency_id,name,vertical_id,ad_server_id,domain) VALUES (%s,%s,%s,%s,%s);'
		return message


	def advertiser_create(self): 
		self.cursor.execute(self.message_constructor(),(self.agency_id,parameters.ADVERTISER_NAME,parameters.VERTICAL_ID,parameters.AD_SERVER_ID,parameters.ADV_DOMAIN))  
		# assert/confirm and *then* print: 
		print "Advertiser has been inserted..." 
		self.get_adv_id_by_name()

	# read : get id of advertiser just created, by name
	def get_adv_id_by_name(self):
		select_statement = "SELECT id FROM advertisers WHERE name='%s' ;" % parameters.ADVERTISER_NAME
		self.cursor.execute(select_statement) 
		advertiser_id = self.cursor.fetchall()[0] 
		#print advertiser_id, type(advertiser_id) 
		self.id = advertiser_id 
		#return advertiser_id 
		

	#give adv_id to concept_maker: 
	#def adv_id_to_concept_maker(self, cursor): 
		 

	# def adv_id_to_concept_maker(self): 
	# 	# to concept 
	# 	concept = Concept(self.cursor, self.get_adv_id_by_name()) 
	# 	concept.get_concept_id_by_name() 
		














