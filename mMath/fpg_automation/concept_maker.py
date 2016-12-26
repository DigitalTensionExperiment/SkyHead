#from campaign_maker import Campaign
#from atomic_creative_maker import AtomicCreative
import parameters 


class Concept(): 

	def __init__(self, cursor, adv_id): 
		self.cursor = cursor
		self. advertiser_id = adv_id
		self.concept_name = parameters.CONCEPT_NAME
		#self.id 
		#self.concept_create 


	def message_constructor(self): 
		message = 'INSERT INTO concepts (advertiser_id,name) VALUES (%s,%s);'
		return message 


	def concept_create(self): 
		self.cursor.execute(self.message_constructor(),(self.advertiser_id,parameters.CONCEPT_NAME))   
		# confirm successful 
		print "Concept has been inserted..." 
		self.get_concept_id_by_name()


	def get_concept_id_by_name(self): 
		select_statement = "SELECT id FROM concepts WHERE name='%s';" % parameters.CONCEPT_NAME 
		self.cursor.execute(select_statement) 
		concept_id = self.cursor.fetchall()[0] 
		self.id = concept_id
		#return self.id



	# def pass_concept_id(self, cursor): 
	# 	# to atomic_creative 
	# 	atomic_creative = AtomicCreative(self.cursor, self.advertiser_id, self.get_concept_id_by_name())
	# 	# to campaign 
	# 	campaign = Campaign(self.cursor, self.advertiser_id, self.get_concept_id_by_name())
		
	


