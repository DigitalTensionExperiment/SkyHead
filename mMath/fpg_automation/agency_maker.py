#from advertiser_maker import Advertiser
import parameters


class Agency(): 

	def __init__(self, cursor, org_id, agency_name=parameters.AGENCY_NAME): 
		self.cursor = cursor
		self.organization_id = org_id  
		self.agency_name = agency_name


	def message_constructor(self): 
		message = "INSERT INTO agencies (organization_id,name) VALUES (%s,%s);" 
		return message


	# create
	def agency_create(self): 
		self.cursor.execute(self.message_constructor(), (self.organization_id, parameters.AGENCY_NAME)) 
		# assert/confirm and *then* print: 
		print "Agency has been inserted..." 
		self.get_agency_id_by_name()


	# read : get id of agency just created, by name
	def get_agency_id_by_name(self): 
		select_statement = "SELECT id FROM agencies WHERE name='%s' ;" % parameters.AGENCY_NAME 
		self.cursor.execute(select_statement) 
		agency_id = self.cursor.fetchall()[0] 
		self.id = agency_id
		#print agency_id, type(agency_id) 
		#return self.id
		

	# give agency_id to advertiser_maker: 
	# def agency_id_to_advertiser_maker(self): 	
	# 	advertiser = Advertiser(self.cursor, self.get_agency_id_by_name()) 

	



	# update 
	# delete 





