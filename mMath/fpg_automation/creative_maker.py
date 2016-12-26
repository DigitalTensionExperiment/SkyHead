import parameters



class Creative(): 



	def __init__(self, cursor, atomic_creative_id): 
		self.cursor = cursor
		self.atomic_creative_id = atomic_creative_id
		self.tag = parameters.TAG 
		self.tag_type = parameters.TAG_TYPE		 
		#self.id 


	def message_constructor(self): 
		message = 'INSERT INTO creatives (atomic_creative_id,tag,tag_type) VALUES (%s,%s,%s);'
		return message


	def creative_create(self): 
		self.cursor.execute(self.message_constructor(),(self.atomic_creative_id,parameters.TAG,parameters.TAG_TYPE))  
		# assert/confirm and *then* print: 
		print "Creative has been inserted..." 


	# read 
	#def get_creative_id():


	


