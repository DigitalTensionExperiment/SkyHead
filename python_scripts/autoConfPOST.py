# write to a confluence page
import xmlrpclib

URL = "https://confluence.medialets.com/display/QA/Audit+report+automation" 
username = 'zareen.wilhelm' 
password = 'srsr07310!'

# get this from the page url while editing
# e.g. ../editpage.action?pageId=132350005 <-- here
pageID = "31068332" 


# and write the new contents
client = xmlrpclib.ServerProxy(URL)
auth_token = client.confluence2.login(username, password)
page = client.confluence2.getPage(auth_token, pageID)

page['content'] = "!!!your content here!!!"

client.confluence2.logout(auth_token)
