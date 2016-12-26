#from strategy_concept_maker import StrategyConcept
import parameters


class Strategy(): 


	def __init__(self, cursor, campaign_id, concept_id):  
		self.cursor = cursor
		self.name = parameters.STRATEGY_NAME
		self.campaign_id = campaign_id
		self.start_date = parameters.START_DATE  
		self.end_date = parameters.END_DATE 
		self.goal_type = parameters.GOAL_TYPE   
		self.budget = parameters.STRATEGY_BUDGET 
		self.pacing_amount = parameters.PACING_AMOUNT 
		self.max_bid = parameters.MAX_BID  
		self.type = parameters.TYPE 
		self.currency_code = parameters.CURRENCY_CODE  
		self.zone_name = parameters.ZONE_NAME
		self.concept_id = concept_id 


	def message_constructor(self): 
		message = 'INSERT INTO strategies (name, campaign_id, start_date, end_date, goal_type, budget, pacing_amount, max_bid, type, currency_code, zone_name) VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s);' 
		return message


	def strategy_create(self):  
		self.cursor.execute(self.message_constructor(),(parameters.STRATEGY_NAME,self.campaign_id,parameters.START_DATE,parameters.END_DATE,parameters.GOAL_TYPE,parameters.STRATEGY_BUDGET,parameters.PACING_AMOUNT,parameters.MAX_BID,parameters.TYPE,parameters.CURRENCY_CODE,parameters.ZONE_NAME)) 
		# ...
		print "Strategy has been inserted..." 
		self.get_strategy_id_by_name()


	def get_strategy_id_by_name(self): 
		select_statement = "SELECT id FROM strategies WHERE name='%s';" % parameters.STRATEGY_NAME 
		self.cursor.execute(select_statement) 
		strategy_id = self.cursor.fetchall()[0]  
		self.id = strategy_id 
		#return self.id


	# def pass_strategy_id(self, cursor): 
	# 	strategy_concept = StrategyConcept(cursor, self.concept_id, self.get_strategy_id_by_name)










