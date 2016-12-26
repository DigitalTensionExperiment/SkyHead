import org_maker 
import agency_maker 


class TestDataCreator(): 

    def __init__(self):
        
        #self.json_payload = json.dumps(self.payload)

    def run(self, cursor): 

    	# make a connection 
    	#	confirm the connection 

    	# create new Org  
        organization_id = OrganizationMaker.org_creater(self,cursor) 
        # give organization_id to agency_maker(): 
        AgencyMaker.agency_maker(cursor, organization_id)
        	

        # " agency 
    	# " advertiser 
    	# " campaign 
    	# " concept 
    	# " atomic_creative 
    	# " creative 
    	# " strategy 
    	# " strategy_concept 
    	# connect Org to Seats 






tdc = TestDataCreator() 
tdc.run() 

