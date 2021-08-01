DELIMITER //
DROP PROCEDURE IF EXISTS P1 //
CREATE PROCEDURE P1()
  BEGIN
    DECLARE v_id INT;
    DECLARE v_x, v_y, v_z VARCHAR(10) DEFAULT 'Test';
    DECLARE v_birthday DATE DEFAULT '2021-07-26';
    DECLARE v_in_stock BOOLEAN DEFAULT FALSE;
    SELECT v_id, v_x, v_y, v_z, v_birthday, v_in_stock;
  END //
DELIMITER ;