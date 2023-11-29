
/* Anzahl Antworten */
select count(*) 
from results 
where remotehost not like '%192.168.%'
and remotehost <> '0.0.0.0'
and remotehost <> '193.109.74.31' 
and remotehost <> '193.109.74.32'



