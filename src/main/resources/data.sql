INSERT INTO houses (id_house, name) 
    SELECT '5a05e2b252f721a3cf2ea33f', 'Gryffindor'
    WHERE NOT EXISTS (
        SELECT 1 FROM houses WHERE id_house='5a05e2b252f721a3cf2ea33f'
    );
INSERT INTO houses (id_house, name) 
    SELECT '123456789012345678901234', 'Slytherin'
    WHERE NOT EXISTS (
        SELECT 1 FROM houses WHERE id_house='123456789012345678901234'
    );
INSERT INTO houses (id_house, name) 
    SELECT 'abcdefghijklmnopqrstuvxz', 'Ravenclaw'
    WHERE NOT EXISTS (
        SELECT 1 FROM houses WHERE id_house='abcdefghijklmnopqrstuvxz'
    );
INSERT INTO houses (id_house, name) 
    SELECT '0102030405abcdefgh070809', 'Hufflepuff'
    WHERE NOT EXISTS (
        SELECT 1 FROM houses WHERE id_house='0102030405abcdefgh070809'
    );

