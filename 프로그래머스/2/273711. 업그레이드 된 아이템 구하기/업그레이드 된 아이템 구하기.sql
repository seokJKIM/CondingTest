select i.ITEM_ID as ITEM_ID, i.ITEM_NAME as ITEM_NAME, i.RARITY as RARITY
from ITEM_INFO i inner join ITEM_TREE t
on i.ITEM_ID = t.ITEM_ID
where t.PARENT_ITEM_ID in (select item_id
                          from item_info
                          where RARITY = 'RARE')
order by ITEM_ID DESC;