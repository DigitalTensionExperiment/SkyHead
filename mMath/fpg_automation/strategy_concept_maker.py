




class StrategyConcept(): 

	def __init__(self, cursor, strategy_id, concept_id): 
		self.cursor = cursor
		self.strategy_id = strategy_id 
		self.concept_id = concept_id


	def message_constructor(self): 
		message = 'INSERT INTO strategy_concepts (strategy_id,concept_id) VALUES (%s,%s);'
		return message 


	# create 
	def strategy_concept_create(self): 
		self.cursor.execute(self.message_constructor(), (self.strategy_id, self.concept_id)) 
		# ... 
		print "Strategy-concept has been inserted..." 


	# read 
	# select_statement = "SELECT id FROM strategy_concepts WHERE strategy_id=%s;" % strategy_id
	# 	cursor.execute(select_statement) 
	# 	strategy_concept_id = cursor.fetchall()[0] 
	# 	print "Strategy_concept concept has been generated..."
	# 	print strategy_concept_id, type(strategy_concept_id)


