#from creative_maker import Creative
import parameters 


class AtomicCreative(): 

	
	def __init__(self, cursor, advertiser_id, concept_id): 
		self.cursor = cursor
		self.advertiser_id = advertiser_id
		self.concept_id = concept_id
		self.name = parameters.ATOMIC_CREATIVE_NAME
		self.width = parameters.WIDTH   
		self.height = parameters.HEIGHT 
		self.external_identifier = parameters.EXTERNAL_IDENTIFIER 
		self.tpas_ad_tag_name = parameters.TPAS_AD_TAG_NAME



	def message_constructure(self): 
		message = 'INSERT INTO atomic_creatives (advertiser_id,concept_id,name,width,height,external_identifier,tpas_ad_tag_name) VALUES (%s,%s,%s,%s,%s,%s,%s);' 
		return message 



	def atomic_creative_create(self): 
		self.cursor.execute(self.message_constructure(),(self.advertiser_id,self.concept_id,parameters.ATOMIC_CREATIVE_NAME,parameters.WIDTH,parameters.HEIGHT,parameters.EXTERNAL_IDENTIFIER, parameters.TPAS_AD_TAG_NAME)) 
		# ... 
		print "Atomic-creative has been inserted..." 
		self.get_atomic_creative_id()


	def get_atomic_creative_id(self): #,advertiser_id,concept_id): 	
		select_statement = "SELECT id FROM atomic_creatives WHERE name='%s';" % parameters.ATOMIC_CREATIVE_NAME
		self.cursor.execute(select_statement) 
		atomic_creative_id = self.cursor.fetchall()[0] 
		self.id = atomic_creative_id 
		#print atomic_creative_id, type(atomic_creative_id)
		#return atomic_creative_id




	# def pass_atomic_creative_id(self):
	# 	CreativeMaker(cursor,self.get_atomic_creative_id)












