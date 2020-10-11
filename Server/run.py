#from analysisVideo import AnalyzeVideo
from database.connect import Database
from datetime import datetime
#analyze = AnalyzeVideo()
db = Database()
fname = 'image/sample3.jpg'

# analyze._analyzeFace(fname)
# analyze._analyzePose(fname)
#analyze._analyzeHand(fname)


# 학생의 하나의 영상 테이블 생성
studentID = "AAA"
today = datetime.today().strftime("%Y%m%d")
args = (studentID,today)
cnt = int(db.checkCnt(args))
cnt=cnt+1
args = (studentID,today,cnt)
db.createOneVideo(args)


# 학생의 하나의 영상에 대한 데이터 삽입
tabName = studentID+"_"+today+"_"+str(cnt-1)
print(tabName)
data = (4,5,3,2,5,19,"timestamp")
args = (tabName,data)
db.insertOneVideo(args)