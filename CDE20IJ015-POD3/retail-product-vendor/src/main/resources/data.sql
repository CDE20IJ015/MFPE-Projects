INSERT INTO "PUBLIC"."VENDOR"("VENDOR_ID","DELIVERY_CHARGE","RATING","VENDOR_NAME") values
(1, 120,4,'Vendor A'),
(2, 150,5,'Vendor B'),
(3, 140,4,'Vendor C'),
(4, 135,4.5,'Vendor D'),
(5, 135,4.6,'Vendor E'),
(6, 140,4.6,'Vendor F');

INSERT INTO "PUBLIC"."VENDOR_STOCK"("VENDOR_STOCK_ID","EXPECTED_STOCK_REPLINSHMENT_DATE","PRODUCT_ID","STOCK_IN_HAND","VENDOR_ID") values
(1,'2021-04-28',1,100,1),
(2,'2021-04-28',1,10,2),
(3,'2021-04-28',1,60,3),
(4,'2021-04-28',2,100,1),
(5,'2021-04-28',1,100,5),
(6,'2021-04-28',1,100,6);