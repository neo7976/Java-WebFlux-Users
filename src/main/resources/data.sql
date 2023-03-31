SELECT u.name, u.telephone_number
FROM Teams t
         JOIN TeamMembers tm ON t.id = tm.team_id
         JOIN users u ON u.id = tm.user_id
WHERE t.id = 1;
