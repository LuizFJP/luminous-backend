-- CREATE TABLE IF NOT EXISTS white_taxes
-- (
--
--
--     flag_id                         SERIAL      NOT NULL,
--
--
--     company_name                    VARCHAR(50) NOT NULL,
--
--
--     normal_price                    REAL        NOT NULL,
--
--
--     low_price                       REAL        NOT NULL,
--
--
--     middle_price                    REAL        NOT NULL,
--
--
--     high_price                      REAL        NOT NULL,
--
--
--     start_hour_low_price            TIME        NOT NULL,
--
--
--     end_hour_low_price              TIME        NOT NULL,
--
--
--     initial_start_hour_middle_price TIME        NOT NULL,
--
--
--     initial_end_hour_middle_price   TIME        NOT NULL,
--
--
--     final_start_hour_middle_price   TIME        NOT NULL,
--
--
--     final_end_hour_middle_price     TIME        NOT NULL,
--
--
--     start_hour_high_price           TIME        NOT NULL,
--
--
--     end_hour_high_price             TIME        NOT NULL,
--
--
--     PRIMARY KEY (flag_id)
--
--
-- );

INSERT INTO energy_provider(energy_provider_id, company_name, url_maintenance, url_energy_fall) VALUES
                           (1,'Amazonas Energia','',''),
                           (2,'Castro-DIS','',''),
                           (3,'CEA Equatorial','',''),
                           (4,'Cedrap','',''),
                           (5,'Cedri','',''),
                           (6,'CEEE Equatorial','',''),
                           (7,'Cegero','',''),
                           (8,'Cejama','',''),
                           (9,'Celesc-DIS','https://www.celesc.com.br/avisos-de-desligamentos','https://celgeoweb.celesc.com.br/desktop.html'),
                           (10,'CELETRO','',''),
                           (11,'Cemig-D','',''),
                           (12,'Cemirim','',''),
                           (13,'Ceprag','',''),
                           (14,'Ceraça','',''),
                           (15,'Ceral Anitápolis','',''),
                           (16,'Ceral Araruama','',''),
                           (17,'Ceral DIS','',''),
                           (18,'Cerbranote','',''),
                           (19,'CERCI','',''),
                           (20,'Cercos','',''),
                           (21,'Cerej','',''),
                           (22,'Ceres','',''),
                           (23,'Cerfox','',''),
                           (24,'Cergal','',''),
                           (25,'Cergapa','',''),
                           (26,'Cergral','',''),
                           (27,'Ceriluz','',''),
                           (28,'Cerim','',''),
                           (29,'Ceripa','',''),
                           (30,'Ceris','',''),
                           (31,'CERMC','',''),
                           (32,'Cermissões','',''),
                           (33,'Cermoful','',''),
                           (34,'Cernhe','',''),
                           (35,'Cerpalo','',''),
                           (36,'Cerpro','',''),
                           (37,'CERRP','',''),
                           (38,'Cersad','',''),
                           (39,'Cersul','',''),
                           (40,'Certaja','',''),
                           (41,'Certel','',''),
                           (42,'Certhil','',''),
                           (43,'Certrel','',''),
                           (44,'Cervam','',''),
                           (45,'Cetril','',''),
                           (46,'Chesp','',''),
                           (47,'Cocel','',''),
                           (48,'Codesam','',''),
                           (49,'Coopera','',''),
                           (50,'Cooperaliança','',''),
                           (51,'Coopercocal','',''),
                           (52,'Cooperluz','',''),
                           (53,'Coopermila','',''),
                           (54,'Coopernorte','',''),
                           (55,'Coopersul','',''),
                           (56,'Cooperzem','',''),
                           (57,'Coorsel','',''),
                           (58,'Copel-DIS','',''),
                           (59,'Coprel','',''),
                           (60,'CPFL Paulista','',''),
                           (61,'CPFL Piratininga','',''),
                           (62,'CPFL Santa Cruz(agrupada)','',''),
                           (63,'Creluz-D','',''),
                           (64,'Creral','',''),
                           (65,'Dcelt','',''),
                           (66,'Demei','',''),
                           (67,'DMED','',''),
                           (68,'EDP ES','',''),
                           (69,'EDP SP','',''),
                           (70,'EFLJC','',''),
                           (71,'Eflul','',''),
                           (72,'Eletrocar','',''),
                           (73,'ELFSM','',''),
                           (74,'Enel CE','',''),
                           (75,'Enel GO','',''),
                           (76,'Enel SP','',''),
                           (77,'Energisa AC','',''),
                           (78,'Energisa MG','',''),
                           (79,'Energisa MT','',''),
                           (80,'Energisa Nova Friburgo','',''),
                           (81,'Energisa PB','',''),
                           (82,'Energisa RO','',''),
                           (83,'Energisa SE','',''),
                           (84,'Energisa Sul Sudeste','',''),
                           (85,'Energisa TO','',''),
                           (86,'Equatorial AL','',''),
                           (87,'Equatorial MA','',''),
                           (88,'Equatorial PA','',''),
                           (89,'Equatorial PI','',''),
                           (90,'Forcel','',''),
                           (91,'Hidropan','',''),
                           (92,'MuxEnergia','',''),
                           (93,'Neonergia Brasília','',''),
                           (94,'Neonergia Coelba','',''),
                           (95,'Neonergia Cosern','',''),
                           (96,'Neonergia Elektro','',''),
                           (97,'Neonergia Pernambuco','','');

INSERT INTO white_tax (energy_provider_id, regular_price, low_price, middle_price, high_price,
                         start_hour_low_price, end_hour_low_price, initial_start_hour_middle_price,
                         initial_end_hour_middle_price, start_hour_high_price, end_hour_high_price,
                         final_start_hour_middle_price, final_end_hour_middle_price)


VALUES (1, 0.835, 0.709, 1.070, 1.615, '00:00:00', '18:30:00', '19:00:00', '20:00:00', '20:00:00',
        '23:00:00', '23:00:00', '00:00:00'),


       (2, 0.466, 0.351, 0.442, 0.534, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),


       (3, 0.722, 0.608, 0.997, 1.492, '23:00:00', '18:00:00', '18:00:00', '19:00:00', '19:00:00',
        '22:00:00', '22:00:00', '23:00:00'),


       (4, 0.994, 0.690, 1.274, 1.858, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00', '20:30:00',
        '20:30:00', '21:30:00'),


       (5, 0.755, 0.620, 0.991, 1.362, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00', '20:30:00',
        '20:30:00', '21:30:00'),


       (6, 0.656, 0.565, 0.821, 1.226, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),


       (7, 0.484, 0.410, 0.585, 0.759, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),


       (8, 0.639, 0.481, 0.852, 1.223, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),


       (9, 0.573, 0.490, 0.656, 0.971, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00',
        '21:30:00', '21:30:00', '22:30:00'),


       (10, 0.740, 0.563, 0.917, 1.271, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),


       (11, 0.653, 0.533, 0.818, 1.250, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),


       (12, 0.531, 0.433, 0.628, 0.823, '21:00:00', '16:00:00', '16:00:00', '17:00:00', '17:00:00', '20:00:00',
        '20:00:00', '21:00:00'),


       (13, 0.727, 0.547, 0.968, 1.390, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),


       (14, 0.551, 0.419, 0.731, 1.042, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),


       (15, 0.678, 0.523, 0.888, 1.252, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00',
        '21:30:00', '21:30:00', '22:30:00'),


       (16, 1.313, 0.940, 1.815, 2.691, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),


       (17, 0.649, 0.527, 0.864, 1.202, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),


       (18, 0.591, 0.474, 0.750, 1.206, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00',
        '21:30:00', '21:30:00', '22:30:00'),


       (19, 1.230, 0.869, 1.717, 2.565, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),


       (20, 0.915, 0.690, 1.365, 2.040, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00', '20:30:00',
        '20:30:00', '21:30:00'),


       (21, 0.686, 0.511, 0.922, 1.333, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),


       (22, 1.272, 0.904, 1.921, 2.939, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),


       (23, 0.727, 0.549, 1.232, 2.086, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),


       (24, 0.785, 0.582, 1.059, 1.537, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),


       (25, 0.596, 0.465, 0.772, 1.079, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),


       (26, 1.313, 0.940, 1.815, 2.691, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),


       (27, 0.596, 0.464, 0.727, 0.990, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),


       (28, 0.715, 0.517, 0.929, 1.341, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),


       (29, 0.712, 0.569, 0.480, 1.159, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (30, 0.787, 0.561, 1.183, 1.806, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00', '20:30:00',
        '20:30:00', '21:30:00'),

       (31, 0.901, 0.636, 0.971, 1.305, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00', '20:30:00',
        '20:30:00', '21:30:00'),

       (32, 0.714, 0.529, 0.899, 1.270, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       (33, 0.727, 0.509, 1.021, 1.533, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       (34, 0.635, 0.500, 0.770, 1.040, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (35, 0.757, 0.496, 1.110, 1.724, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       (36, 0.752, 0.600, 0.928, 1.255, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (37, 0.767, 0.592, 0.942, 1.292, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (38, 0.538, 0.441, 0.670, 0.899, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       (39, 0.499, 0.387, 0.651, 0.916, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       (40, 0.551, 0.425, 0.743, 1.351, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (41, 0.583, 0.491, 0.792, 1.092, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (42, 0.599, 0.458, 0.740, 1.022, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (43, 0.782, 0.537, 1.112, 1.688, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       (44, 0.623, 0.492, 0.854, 1.217, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00', '20:30:00',
        '20:30:00', '21:30:00'),

       (45, 0.798, 0.561, 1.054, 1.548, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (46, 0.671, 0.564, 0.783, 1.165, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (47, 0.570, 0.483, 0.674, 1.005, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (48, 0.519, 0.443, 0.622, 0.801, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       (49, 0.459, 0.369, 0.579, 0.769, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       (50, 0.573, 0.490, 0.656, 0.971, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00',
        '21:30:00', '21:30:00', '22:30:00'),

       (51, 0.619, 0.468, 0.822, 1.175, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00',
        '21:30:00', '21:30:00', '22:30:00'),

       (52, 0.505, 0.429, 0.575, 0.720, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (53, 0.533, 0.443, 0.654, 0.865, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00',
        '21:30:00', '21:30:00', '22:30:00'),

       (54, 0.890, 0.685, 1.356, 2.027, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       (55, 0.700, 0.613, 0.950, 1.288, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (56, 0.643, 0.512, 0.819, 1.126, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       (57, 0.627, 0.491, 0.810, 1.129, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       (58, 0.570, 0.483, 0.674, 1.005, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (59, 0.490, 0.448, 0.697, 0.717, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (60, 0.662, 0.537, 0.757, 1.156, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       (61, 0.680, 0.568, 0.769, 1.154, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       (62, 0.592, 0.482, 0.693, 1.049, '22:00:00', '17:00:00', '17:00:00', '18:00:00',
        '18:00:00', '21:00:00', '21:00:00', '22:00:00'),

       (63, 0.733, 0.584, 1.071, 1.558, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (64, 0.767, 0.603, 1.140, 1.677, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (65, 0.573, 0.490, 0.656, 0.971, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (66, 0.681, 0.541, 0.841, 1.290, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (67, 0.653, 0.533, 0.818, 1.250, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (68, 0.674, 0.566, 0.816, 1.225, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (69, 0.654, 0.530, 0.744, 1.105, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00', '20:30:00',
        '20:30:00', '21:30:00'),

       (70, 0.573, 0.490, 0.656, 0.971, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       (71, 0.573, 0.490, 0.656, 0.971, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       (72, 0.561, 0.418, 0.714, 1.218, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (73, 0.755, 0.647, 0.961, 1.456, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (74, 0.709, 0.586, 0.974, 1.534, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00', '20:30:00',
        '20:30:00', '21:30:00'),

       (75, 0.671, 0.564, 0.783, 1.165, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (76, 0.656, 0.541, 0.828, 1.258, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00', '20:30:00',
        '20:30:00', '21:30:00'),

       (77, 0.733, 0.592, 1.030, 1.611, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00',
        '21:30:00', '21:30:00', '22:30:00'),

       (78, 0.766, 0.628, 0.903, 1.374, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       (79, 0.814, 0.654, 1.114, 1.728, '21:30:00', '15:30:00', '15:30:00', '17:30:00', '17:30:00',
        '20:30:00', '20:30:00', '21:30:00'),

       (80, 0.822, 0.638, 0.968, 1.522, '22:00:00', '17:00:00', '17:00:00', '18:00:00',
        '18:00:00', '21:00:00', '21:00:00', '22:00:00'),

       (81, 0.599, 0.497, 0.822, 1.274, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00',
        '20:30:00', '20:30:00', '21:30:00'),

       (82, 0.657, 0.544, 0.880, 1.340, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00',
        '21:30:00', '21:30:00', '22:30:00'),

       (83, 0.646, 0.506, 0.892, 1.416, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00',
        '20:30:00', '20:30:00', '21:30:00'),

       (84, 0.622, 0.535, 0.775, 1.175, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       (85, 0.762, 0.612, 1.097, 1.747, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       (86, 0.750, 0.633, 1.041, 1.602, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00',
        '20:30:00', '20:30:00', '21:30:00'),

       (87, 0.651, 0.529, 0.906, 1.415, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       (88, 0.879, 0.682, 1.288, 2.024, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00',
        '21:30:00', '21:30:00', '22:30:00'),

       (89, 0.743, 0.620, 1.069, 1.667, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00',
        '20:30:00', '20:30:00', '21:30:00'),

       (90, 0.558, 0.444, 0.709, 1.093, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (91, 0.523, 0.384, 0.636, 1.079, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       (92, 0.604, 0.439, 0.770, 1.315, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       (93, 0.699, 0.610, 0.777, 1.152, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       (94, 0.746, 0.594, 1.046, 1.656, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       (95, 0.662, 0.549, 0.916, 1.452, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       (96, 0.731, 0.613, 0.906, 1.345, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00',
        '20:30:00', '20:30:00', '21:30:00'),

       (97, 0.706, 0.601, 0.932, 1.450, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00',
        '20:30:00', '20:30:00', '21:30:00');

INSERT INTO weather_tip (tip, climate) VALUES
                                            ('Desligue os ventiladores e ar-condicionado', 'COLD'),
                                            ('Use roupas quentes para evitar ligar o aquecedor', 'COLD'),
                                            ('Use cobertores eficientes para dormir', 'COLD'),
                                            ('Sensação de frio aumentando? Exercite-se', 'COLD'),
                                            ('Desligue os aquecedores', 'HOT'),
                                            ('Use roupas mais leves', 'HOT'),
                                            ('Evite o uso de chuveiro elétrico', 'HOT'),
                                            ('Feche as cortinas para diminuir o aquecimento do ambiente', 'HOT'),
                                            ('Abra as janelas para a entrada de ar fresco!', 'HOT');

INSERT INTO users (user_id, name, phone, user_name, email, password, birthdate)
    VALUES (10, 'Testador', '123456789', 'tester', 'email@email', '$2a$10$xEnEKVKE2nkt.BRidai5ZOT.Qk4f93TQLAYui1gL7/2S4wJ/QddJO', '1950-12-12');


INSERT INTO address (id, main_address, state, city, cep, street, neighborhood, house_number, input_voltage, user_id, energy_provider_id)
    VALUES (10, true, 'SP','São Paulo', '00000-000', 'Avenida Paulista', 'cachoeirinha do grau' , 123, 110, 10, 9);
--            (20, 'São Paulo', '00000-000', 'cachoeirinha do grau', 'Avenida Paulista', 234, 110, 10),
--            (30, 'São Paulo', '00000-000', 'cachoeirinha do grau', 'Avenida Paulista', 345, 220, 10);

INSERT INTO device (id, name, power, usage_time, address_id)
    VALUES (10, 'Geladeira', 220, '23:59', 10),
           (11, 'Computador', 1200, '06:00', 10),
           (12, 'Microondas', 900, '10:00', 10);

INSERT INTO tariff_flag (month, flag_type)
    VALUES('2023-02-01', 0),
          ('2023-03-01', 1),
          ('2023-04-01', 2);

INSERT INTO tip (id, tip_title, tip_message)
VALUES
    (1, 'Utilize lâmpadas de baixo consumo', 'Substitua lâmpadas incandescentes por lâmpadas de LED, que consomem menos energia e possuem maior durabilidade.'),
    (2, 'Desligue aparelhos eletrônicos em standby', 'Mesmo em standby, os aparelhos consomem energia. Desligue completamente quando não estiverem em uso.'),
    (3, 'Aproveite a luz natural', 'Abra cortinas e aproveite a luz natural durante o dia, reduzindo a necessidade de iluminação artificial.'),
    (4, 'Utilize a função de suspensão do computador', 'Ao não utilizar o computador, coloque-o em modo de suspensão para economizar energia.'),
    (5, 'Não deixe eletrônicos em modo de espera', 'Desligue completamente os aparelhos eletrônicos quando não estiverem sendo utilizados.'),
    (6, 'Utilize a máquina de lavar com carga completa', 'Evite lavar roupas com poucas peças. Espere até ter uma carga completa para utilizar a máquina de lavar.'),
    (7, 'Desligue as luzes ao sair de um cômodo', 'Lembre-se de desligar as luzes sempre que sair de um ambiente para economizar energia.'),
    (8, 'Utilize a função de economia de energia do ar-condicionado', 'Configure o ar-condicionado para a função de economia de energia e ajuste a temperatura para um nível confortável.'),
    (9, 'Evite abrir a porta da geladeira desnecessariamente', 'Ao abrir a porta da geladeira, o ar frio escapa e faz com que o aparelho precise trabalhar mais para resfriar novamente.'),
    (10, 'Desligue o carregador do celular após a carga completa', 'Retire o carregador da tomada após o celular estar completamente carregado para evitar desperdício de energia. '),
    (11, 'Utilize cortinas ou persianas para isolar o calor', 'Durante o verão, mantenha as cortinas ou persianas fechadas nos horários mais quentes para reduzir a entrada de calor.'),
    (12, 'Evite o uso excessivo do aquecedor', 'Use roupas adequadas e mantenha-se aquecido com cobertores antes de recorrer ao aquecedor, evitando assim o consumo excessivo de energia.'),
    (13, 'Descongele regularmente o freezer', 'O acúmulo de gelo no freezer reduz sua eficiência energética. Descongele-o regularmente para evitar o desperdício de energia.'),
    (14, 'Utilize a função de autodesligamento da TV', 'Configure a TV para desligar automaticamente após um período de inatividade, evitando assim o consumo de energia desnecessário.'),
    (15, 'Limpe regularmente as lâmpadas e luminárias', 'Lâmpadas e luminárias sujas reduzem a eficiência da iluminação, exigindo mais energia para iluminar adequadamente o ambiente. Mantenha-os limpos regularmente.'),
    (16, 'Aproveite a luz natural para secar roupas', 'Em dias ensolarados, opte por secar roupas ao ar livre em vez de usar a secadora, aproveitando a energia gratuita do sol.'),
    (17, 'Utilize ar-condicionado com a temperatura adequada', 'Evite ajustar o ar-condicionado para temperaturas muito baixas ou muito altas. Defina a temperatura para um nível confortável e economize energia.'),
    (18, 'Desligue o computador quando não estiver em uso', 'Ao deixar o computador por um período prolongado, desligue-o completamente para economizar energia.'),
    (19, 'Utilize a função de economia de água da máquina de lavar', 'Configure a máquina de lavar para utilizar a quantidade adequada de água de acordo com a carga de roupas, economizando energia e recursos hídricos.'),
    (20, 'Realize manutenção regular em equipamentos elétricos', 'Equipamentos elétricos bem conservados e com manutenção adequada tendem a ser mais eficientes em termos de consumo de energia.'),
    (21, 'Invista em sistemas de energia solar', 'Considere a instalação de painéis solares em sua residência. Essa é uma opção sustentável que pode reduzir significativamente o consumo de energia elétrica.'),
    (22, 'Utilize eletrodomésticos de alta eficiência energética', 'Ao adquirir novos eletrodomésticos, verifique a classificação de eficiência energética e escolha os modelos mais eficientes, que consomem menos energia.'),
    (23, 'Automatize o sistema de iluminação', 'Utilize sistemas de automação residencial para controlar as luzes. Dessa forma, você poderá programar horários de ligar e desligar, evitando o desperdício de energia.'),
    (24, 'Instale janelas com vidros duplos', 'As janelas com vidros duplos proporcionam um melhor isolamento térmico e acústico, reduzindo a necessidade de aquecimento ou refrigeração, o que resulta em economia de energia.'),
    (25, 'Utilize sistemas de aquecimento solar de água', 'Ao invés de utilizar aquecedores elétricos, opte por sistemas de aquecimento solar de água. Eles aproveitam a energia solar para aquecer a água, reduzindo o consumo de energia elétrica.'),
    (26, 'Faça uso de lâmpadas LED de alta eficiência', 'Substitua as lâmpadas convencionais por lâmpadas de LED de alta eficiência energética. Elas consomem menos energia e possuem maior durabilidade.'),
    (27, 'Instale sensores de movimento para iluminação', 'Utilize sensores de movimento para acionar a iluminação em áreas de baixo tráfego, garantindo que as luzes sejam ativadas somente quando necessário.'),
    (28, 'Realize isolamento térmico nas paredes e no telhado', 'Invista em isolamento térmico de alta qualidade nas paredes e no telhado de sua residência. Isso ajudará a manter a temperatura interna estável, reduzindo a necessidade de aquecimento ou refrigeração.'),
    (29, 'Utilize sistemas de ventilação eficientes', 'Instale sistemas de ventilação eficientes, como ventiladores de teto ou sistemas de ventilação mecânica controlada. Eles promovem a circulação de ar e reduzem a necessidade de refrigeração.'),
    (30, 'Utilize cortinas ou persianas com isolamento térmico', 'Invista em cortinas ou persianas com isolamento térmico para reduzir a transferência de calor pela janela, mantendo a temperatura interna mais agradável.'),
    (31, 'Utilize sistemas de climatização com controle de temperatura', 'Opte por sistemas de climatização que permitam o controle individual da temperatura em cada ambiente da casa, evitando o desperdício de energia.'),
    (32, 'Instale painéis solares fotovoltaicos', 'Além dos painéis solares para aquecimento de água, considere também a instalação de painéis solares fotovoltaicos para geração de energia elétrica. Isso permitirá reduzir a dependência da rede elétrica.'),
    (33, 'Adote o uso de sistemas de armazenamento de energia', 'Complemente seu sistema de painéis solares com sistemas de armazenamento de energia, como baterias. Isso possibilita o armazenamento da energia produzida durante o dia para uso durante a noite, reduzindo a necessidade de consumo da rede elétrica.'),
    (34, 'Utilize sistemas de automação residencial avançados', 'Invista em sistemas de automação residencial mais avançados, que permitem o monitoramento e controle detalhado do consumo de energia em cada dispositivo e a otimização do uso de energia.'),
    (35, 'Faça o uso de eletrodomésticos inteligentes', 'Opte por eletrodomésticos inteligentes que possuem recursos de otimização de energia, como a programação para operar em horários de menor demanda.'),
    (36, 'Instale sistemas de aquecimento geotérmico', 'Os sistemas de aquecimento geotérmico utilizam a energia térmica do subsolo para aquecer ou refrigerar sua residência. Essa opção é altamente eficiente e sustentável.'),
    (37, 'Realize o monitoramento do consumo de energia em tempo real', 'Instale dispositivos de monitoramento de energia que forneçam informações em tempo real sobre o consumo de energia da sua casa, permitindo ajustes e identificação de desperdícios.'),
    (38, 'Utilize painéis de vidro isolante nas janelas', 'Painéis de vidro isolante ajudam a reduzir a perda de calor no inverno e o ganho de calor no verão, mantendo a temperatura interna mais estável e reduzindo a necessidade de aquecimento e refrigeração.'),
    (39, 'Faça uso de sistemas de irrigação eficientes', 'Se você possui um jardim, utilize sistemas de irrigação eficientes, como gotejamento ou aspersão de baixo volume, para evitar o desperdício de água e energia.'),
    (40, 'Invista em isolamento acústico nas paredes e no telhado', 'Além do isolamento térmico, o isolamento acústico também é importante. Invista em materiais que ajudem a reduzir a entrada de ruídos externos, proporcionando maior conforto e qualidade de vida.');




INSERT INTO Consumption (id, energy_consumptionkwh, energy_consumption_reais, period, device_id)
VALUES (1001, 5.2763, 2.6381, '2023-03-31', 10),
       (1002, 5.2763, 2.6381, '2023-04-01', 10),
       (1003, 5.2763, 2.6381, '2023-04-02', 10),
       (1004, 5.2763, 2.6381, '2023-04-03', 10),
       (1005, 5.2763, 2.6381, '2023-04-04', 10),
       (1006, 5.2763, 2.6381, '2023-04-05', 10),
       (1007, 5.2763, 2.6381, '2023-04-06', 10),
       (1008, 5.2763, 2.6381, '2023-04-07', 10),
       (1009, 5.2763, 2.6381, '2023-04-08', 10),
       (1010, 5.2763, 2.6381, '2023-04-09', 10),
       (1011, 5.2763, 2.6381, '2023-04-10', 10),
       (1012, 5.2763, 2.6381, '2023-04-11', 10),
       (1013, 5.2763, 2.6381, '2023-04-12', 10),
       (1014, 5.2763, 2.6381, '2023-04-13', 10),
       (1015, 5.2763, 2.6381, '2023-04-14', 10),
       (1016, 5.2763, 2.6381, '2023-04-15', 10),
       (1017, 5.2763, 2.6381, '2023-04-16', 10),
       (1018, 5.2763, 2.6381, '2023-04-17', 10),
       (1019, 5.2763, 2.6381, '2023-04-18', 10),
       (1020, 5.2763, 2.6381, '2023-04-19', 10),
       (1021, 5.2763, 2.6381, '2023-04-20', 10),
       (1022, 5.2763, 2.6381, '2023-04-21', 10),
       (1023, 5.2763, 2.6381, '2023-04-22', 10),
       (1024, 5.2763, 2.6381, '2023-04-23', 10),
       (1025, 5.2763, 2.6381, '2023-04-24', 10),
       (1026, 5.2763, 2.6381, '2023-04-25', 10),
       (1027, 5.2763, 2.6381, '2023-04-26', 10),
       (1028, 5.2763, 2.6381, '2023-04-27', 10),
       (1029, 5.2763, 2.6381, '2023-04-28', 10),
       (1030, 5.2763, 2.6381, '2023-04-29', 10),
       (1031, 5.2763, 2.6381, '2023-04-30', 10),
       (1032, 5.2763, 2.6381, '2023-05-01', 10),
       (1033, 5.2763, 2.6381, '2023-05-02', 10),
       (1034, 5.2763, 2.6381, '2023-05-03', 10),
       (1035, 5.2763, 2.6381, '2023-05-04', 10),
       (1036, 5.2763, 2.6381, '2023-05-05', 10),
       (1037, 5.2763, 2.6381, '2023-05-06', 10),
       (1038, 5.2763, 2.6381, '2023-05-07', 10),
       (1039, 5.2763, 2.6381, '2023-05-08', 10),
       (1040, 5.2763, 2.6381, '2023-05-09', 10),
       (1041, 5.2763, 2.6381, '2023-05-10', 10),
       (1042, 5.2763, 2.6381, '2023-05-11', 10),
       (1043, 5.2763, 2.6381, '2023-05-12', 10),
       (1044, 5.2763, 2.6381, '2023-05-13', 10),
       (1045, 5.2763, 2.6381, '2023-05-14', 10),
       (1046, 5.2763, 2.6381, '2023-05-15', 10),
       (1047, 5.2763, 2.6381, '2023-05-16', 10),
       (1048, 5.2763, 2.6381, '2023-05-17', 10),
       (1049, 5.2763, 2.6381, '2023-05-18', 10),
       (1050, 5.2763, 2.6381, '2023-05-19', 10),
       (1051, 5.2763, 2.6381, '2023-05-20', 10),
       (1052, 5.2763, 2.6381, '2023-05-21', 10),
       (1053, 5.2763, 2.6381, '2023-05-22', 10),
       (1054, 5.2763, 2.6381, '2023-05-23', 10),
       (1055, 5.2763, 2.6381, '2023-05-24', 10),
       (1056, 5.2763, 2.6381, '2023-05-25', 10),
       (1057, 5.2763, 2.6381, '2023-05-26', 10),
       (1058, 5.2763, 2.6381, '2023-05-27', 10),
       (1059, 5.2763, 2.6381, '2023-05-28', 10),
       (1060, 5.2763, 2.6381, '2023-05-29', 10),
       (1061, 5.2763, 2.6381, '2023-05-30', 10),
       (1062, 5.2763, 2.6381, '2023-05-31', 10),
       (1063, 5.2763, 2.6381, '2023-06-01', 10),
       (1064, 7.2, 3.6, '2023-03-31', 11),
       (1065, 7.2, 3.6, '2023-04-01', 11),
       (1066, 7.2, 3.6, '2023-04-02', 11),
       (1067, 7.2, 3.6, '2023-04-03', 11),
       (1068, 7.2, 3.6, '2023-04-04', 11),
       (1069, 7.2, 3.6, '2023-04-05', 11),
       (1070, 7.2, 3.6, '2023-04-06', 11),
       (1071, 7.2, 3.6, '2023-04-07', 11),
       (1072, 7.2, 3.6, '2023-04-08', 11),
       (1073, 7.2, 3.6, '2023-04-09', 11),
       (1074, 7.2, 3.6, '2023-04-10', 11),
       (1075, 7.2, 3.6, '2023-04-11', 11),
       (1076, 7.2, 3.6, '2023-04-12', 11),
       (1077, 7.2, 3.6, '2023-04-13', 11),
       (1078, 7.2, 3.6, '2023-04-14', 11),
       (1079, 7.2, 3.6, '2023-04-15', 11),
       (1080, 7.2, 3.6, '2023-04-16', 11),
       (1081, 7.2, 3.6, '2023-04-17', 11),
       (1082, 7.2, 3.6, '2023-04-18', 11),
       (1083, 7.2, 3.6, '2023-04-19', 11),
       (1084, 7.2, 3.6, '2023-04-20', 11),
       (1085, 7.2, 3.6, '2023-04-21', 11),
       (1086, 7.2, 3.6, '2023-04-22', 11),
       (1087, 7.2, 3.6, '2023-04-23', 11),
       (1088, 7.2, 3.6, '2023-04-24', 11),
       (1089, 7.2, 3.6, '2023-04-25', 11),
       (1090, 7.2, 3.6, '2023-04-26', 11),
       (1091, 7.2, 3.6, '2023-04-27', 11),
       (1092, 7.2, 3.6, '2023-04-28', 11),
       (1093, 7.2, 3.6, '2023-04-29', 11),
       (1094, 7.2, 3.6, '2023-04-30', 11),
       (1095, 7.2, 3.6, '2023-05-01', 11),
       (1096, 7.2, 3.6, '2023-05-02', 11),
       (1097, 7.2, 3.6, '2023-05-03', 11),
       (1098, 7.2, 3.6, '2023-05-04', 11),
       (1099, 7.2, 3.6, '2023-05-05', 11),
       (1100, 7.2, 3.6, '2023-05-06', 11),
       (1101, 7.2, 3.6, '2023-05-07', 11),
       (1102, 7.2, 3.6, '2023-05-08', 11),
       (1103, 7.2, 3.6, '2023-05-09', 11),
       (1104, 7.2, 3.6, '2023-05-10', 11),
       (1105, 7.2, 3.6, '2023-05-11', 11),
       (1106, 7.2, 3.6, '2023-05-12', 11),
       (1107, 7.2, 3.6, '2023-05-13', 11),
       (1108, 7.2, 3.6, '2023-05-14', 11),
       (1109, 7.2, 3.6, '2023-05-15', 11),
       (1110, 7.2, 3.6, '2023-05-16', 11),
       (1111, 7.2, 3.6, '2023-05-17', 11),
       (1112, 7.2, 3.6, '2023-05-18', 11),
       (1113, 7.2, 3.6, '2023-05-19', 11),
       (1114, 7.2, 3.6, '2023-05-20', 11),
       (1115, 7.2, 3.6, '2023-05-21', 11),
       (1116, 7.2, 3.6, '2023-05-22', 11),
       (1117, 7.2, 3.6, '2023-05-23', 11),
       (1118, 7.2, 3.6, '2023-05-24', 11),
       (1119, 7.2, 3.6, '2023-05-25', 11),
       (1120, 7.2, 3.6, '2023-05-26', 11),
       (1121, 7.2, 3.6, '2023-05-27', 11),
       (1122, 7.2, 3.6, '2023-05-28', 11),
       (1123, 7.2, 3.6, '2023-05-29', 11),
       (1124, 7.2, 3.6, '2023-05-30', 11),
       (1125, 7.2, 3.6, '2023-05-31', 11),
       (1126, 7.2, 3.6, '2023-06-01', 11),
       (1127, 9, 4.5, '2023-03-31', 12),
       (1128, 9, 4.5, '2023-04-01', 12),
       (1129, 9, 4.5, '2023-04-02', 12),
       (1130, 9, 4.5, '2023-04-03', 12),
       (1131, 9, 4.5, '2023-04-04', 12),
       (1132, 9, 4.5, '2023-04-05', 12),
       (1133, 9, 4.5, '2023-04-06', 12),
       (1134, 9, 4.5, '2023-04-07', 12),
       (1135, 9, 4.5, '2023-04-08', 12),
       (1136, 9, 4.5, '2023-04-09', 12),
       (1137, 9, 4.5, '2023-04-10', 12),
       (1138, 9, 4.5, '2023-04-11', 12),
       (1139, 9, 4.5, '2023-04-12', 12),
       (1140, 9, 4.5, '2023-04-13', 12),
       (1141, 9, 4.5, '2023-04-14', 12),
       (1142, 9, 4.5, '2023-04-15', 12),
       (1143, 9, 4.5, '2023-04-16', 12),
       (1144, 9, 4.5, '2023-04-17', 12),
       (1145, 9, 4.5, '2023-04-18', 12),
       (1146, 9, 4.5, '2023-04-19', 12),
       (1147, 9, 4.5, '2023-04-20', 12),
       (1148, 9, 4.5, '2023-04-21', 12),
       (1149, 9, 4.5, '2023-04-22', 12),
       (1150, 9, 4.5, '2023-04-23', 12),
       (1151, 9, 4.5, '2023-04-24', 12),
       (1152, 9, 4.5, '2023-04-25', 12),
       (1153, 9, 4.5, '2023-04-26', 12),
       (1154, 9, 4.5, '2023-04-27', 12),
       (1155, 9, 4.5, '2023-04-28', 12),
       (1156, 9, 4.5, '2023-04-29', 12),
       (1157, 9, 4.5, '2023-04-30', 12),
       (1158, 9, 4.5, '2023-05-01', 12),
       (1159, 9, 4.5, '2023-05-02', 12),
       (1160, 9, 4.5, '2023-05-03', 12),
       (1161, 9, 4.5, '2023-05-04', 12),
       (1162, 9, 4.5, '2023-05-05', 12),
       (1163, 9, 4.5, '2023-05-06', 12),
       (1164, 9, 4.5, '2023-05-07', 12),
       (1165, 9, 4.5, '2023-05-08', 12),
       (1166, 9, 4.5, '2023-05-09', 12),
       (1167, 9, 4.5, '2023-05-10', 12),
       (1168, 9, 4.5, '2023-05-11', 12),
       (1169, 9, 4.5, '2023-05-12', 12),
       (1170, 9, 4.5, '2023-05-13', 12),
       (1171, 9, 4.5, '2023-05-14', 12),
       (1172, 9, 4.5, '2023-05-15', 12),
       (1173, 9, 4.5, '2023-05-16', 12),
       (1175, 9, 4.5, '2023-05-18', 12),
       (1176, 9, 4.5, '2023-05-19', 12),
       (1177, 9, 4.5, '2023-05-20', 12),
       (1178, 9, 4.5, '2023-05-21', 12),
       (1179, 9, 4.5, '2023-05-22', 12),
       (1180, 9, 4.5, '2023-05-23', 12),
       (1181, 9, 4.5, '2023-05-24', 12),
       (1182, 9, 4.5, '2023-05-25', 12),
       (1183, 9, 4.5, '2023-05-26', 12),
       (1184, 9, 4.5, '2023-05-27', 12),
       (1185, 9, 4.5, '2023-05-28', 12),
       (1186, 9, 4.5, '2023-05-29', 12),
       (1187, 9, 4.5, '2023-05-30', 12),
       (1188, 9, 4.5, '2023-05-31', 12),
       (1189, 9, 4.5, '2023-06-01', 12),
       (1190, 5.2763, 2.6381, '2023-06-02', 10),
       (1191, 7.2, 3.6, '2023-06-02', 11),
       (1192, 9, 4.5, '2023-06-02', 12);

