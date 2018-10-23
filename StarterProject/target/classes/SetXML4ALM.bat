
CD "C:\Program Files (x86)\Jenkins\workspace\NEXT_QC_UPDATE"
MOVE "testng-results.xml" %DATE:~-4%-%DATE:~4,2%-%DATE:~7,2%-%TIME:~1,1%-%TIME:~6,2%-%TIME:~9,2%.xml
MOVE *.XML .\Backup\
CD "C:\Users\025204116\workspace\HotPortal_ver01\test-output\"

REM COPY "C:\Users\025204116\workspace\HotPortal_ver01\test-output\testng-results.xml" "C:\Program Files (x86)\Jenkins\workspace\NEXT_QC_UPDATE\testng-results.xml"

"C:\Program Files (x86)\Jenkins\workspace\NEXT_QC_UPDATE\JustCopy1.bat"
PAUSE