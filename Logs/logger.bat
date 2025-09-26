cd /d "D:\Public Git Repos\Jenas Hansda\Logs"
echo Log for %date% >> Logs.txt
git add Logs.txt
git commit -m "Today's Log : %date%"
git push origin main
