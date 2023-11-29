/*
// Mit ToDay() 	 == heute
// Mit ToDay() - 1	 == gestern und heute
// Absteigende Sortierung !!!!
*/

select	' ' + left(zeitstempel,19) + ' ' as zeitstempel, remotehost,String(remoteport) as remoteport,left(cmd,20) as cmd,
	left(subcmd,22) as subcmd,left(username,10) as username, sessionid + '  ' as sessionid,left(servername,30) as servername
from	kl_kochbuchlog 
where	zeitstempel > today()  - 3
and	remotehost not like '192.%' and remotehost not like '127.%'
order by zeitstempel DESC;

delete from kl_kochbuchlog where zeitstempel < (today() - 31);

commit;

