#from strategy_maker import Strategy
import parameters 


class Campaign(): 


	def __init__(self, cursor, advertiser_id, concept_id): 
		self.cursor = cursor
		self.advertiser_id = advertiser_id 
		self.concept_id = concept_id
		self.status = True
		self.name = parameters.CAMPAIGN_NAME
		self.ad_server_id = parameters.AD_SERVER_ID 
		self.start_date = parameters.START_DATE  
		self.end_date = parameters.END_DATE
		self.goal_type = parameters.GOAL_TYPE  
		self.total_budget = parameters.CAMPAIGN_BUDGET   
		self.service_type = parameters.SERVICE_TYPE   
		self.currency_code = parameters.CURRENCY_CODE
		


	def message_constructor(self): 
		message = 'INSERT INTO campaigns (advertiser_id,status,name,ad_server_id,start_date,end_date,goal_type,total_budget,service_type,currency_code) VALUES (%s,true,%s,%s,%s,%s,%s,%s,%s,%s);'
		return message 


	def campaign_create(self): 
		self.cursor.execute(self.message_constructor(), (self.advertiser_id,parameters.CAMPAIGN_NAME,parameters.AD_SERVER_ID,parameters.START_DATE,parameters.END_DATE,parameters.GOAL_TYPE,parameters.CAMPAIGN_BUDGET,parameters.SERVICE_TYPE,parameters.CURRENCY_CODE)) 
		# confirm success 
		print "Campaign has been inserted..." 
		self.get_camp_id_by_name()


	def get_camp_id_by_name(self): 
		select_statement = "SELECT id FROM campaigns WHERE name='%s';" % parameters.CAMPAIGN_NAME 
		self.cursor.execute(select_statement) 
		campaign_id = self.cursor.fetchall()[0] 
		self.id = campaign_id 
		#return campaign_id



	# def camp_id_to_strategy_maker(self, cursor): 
	# 	strategy = Strategy(cursor, self.get_camp_id_by_name, self.concept_id)














