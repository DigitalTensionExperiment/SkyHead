import parameters
#from agency_maker import Agency


class Organization(): 

	def __init__(self, cursor): 
		self.cursor = cursor
		self.name = parameters.ORG_NAME
		self.status = True #parameters.ORG_STATUS
		self.contact_name = parameters.ORG_CONTACT_NAME
		self.address_1 = parameters.ADD1
		self.city = parameters.CITY 
		self.state = parameters.STATE 
		self.zip = parameters.ZIP 
		self.phone = parameters.PHONE 
		self.mm_contact_name = parameters.MM_CONTACT_NAME
		self.allow_x_agency_pixels = True 
		#self.id 

		
	def message_constructor(self): 
		message = 'INSERT INTO organizations (name,status,contact_name,address_1,city,state,zip,phone,mm_contact_name,allow_x_agency_pixels) VALUES (%s,true,%s,%s,%s,%s,%s,%s,%s,true);'
		return message


	# create 
	def org_create(self): 
		self.cursor.execute(self.message_constructor(),(parameters.ORG_NAME,parameters.ORG_CONTACT_NAME,parameters.ADD1,parameters.CITY,parameters.STATE,parameters.ZIP,parameters.PHONE,parameters.MM_CONTACT_NAME)) 
		# assert/confirm and *then* print: 
		print "Organization has been inserted..."  
		# get id of this^ org: 
		self.get_org_id_by_name()


	# read : get the id of the org just created, by name 
	def get_org_id_by_name(self): 
		select_statement = "SELECT id FROM organizations WHERE name='%s' ;" % parameters.ORG_NAME
		self.cursor.execute(select_statement) 
		organization_id = self.cursor.fetchall()[0] 
		#print organization_id, type(parameters.ORG_NAME) 
		self.id = organization_id 
		#return self.id

	
	# give org_id to agency_maker: 
	# def pass_org_id(self): 	
	# 	agency = Agency(self.cursor, self.get_org_id_by_name(cursor))

	


	# update 
	# delete 



		
		
		



