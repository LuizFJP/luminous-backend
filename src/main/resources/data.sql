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


INSERT INTO white_taxes (company_name, regular_price, low_price, middle_price, high_price,
                         start_hour_low_price, end_hour_low_price, initial_start_hour_middle_price,
                         initial_end_hour_middle_price, start_hour_high_price, end_hour_high_price,
                         final_start_hour_middle_price, final_end_hour_middle_price)


VALUES ('Amazonas Energia', 0.835, 0.709, 1.070, 1.615, '00:00:00', '18:30:00', '19:00:00', '20:00:00', '20:00:00',
        '23:00:00', '23:00:00', '00:00:00'),


       ('Castro-DIS', 0.466, 0.351, 0.442, 0.534, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),


       ('CEA Equatorial', 0.722, 0.608, 0.997, 1.492, '23:00:00', '18:00:00', '18:00:00', '19:00:00', '19:00:00',
        '22:00:00', '22:00:00', '23:00:00'),


       ('Cedrap', 0.994, 0.690, 1.274, 1.858, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00', '20:30:00',
        '20:30:00', '21:30:00'),


       ('Cedri', 0.755, 0.620, 0.991, 1.362, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00', '20:30:00',
        '20:30:00', '21:30:00'),


       ('CEEE Equatorial', 0.656, 0.565, 0.821, 1.226, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),


       ('Cegero', 0.484, 0.410, 0.585, 0.759, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),


       ('Cejama', 0.639, 0.481, 0.852, 1.223, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),


       ('Celesc-DIS', 0.573, 0.490, 0.656, 0.971, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00',
        '21:30:00', '21:30:00', '22:30:00'),


       ('CELETRO', 0.740, 0.563, 0.917, 1.271, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),


       ('Cemig-D', 0.653, 0.533, 0.818, 1.250, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),


       ('Cemirim', 0.531, 0.433, 0.628, 0.823, '21:00:00', '16:00:00', '16:00:00', '17:00:00', '17:00:00', '20:00:00',
        '20:00:00', '21:00:00'),


       ('Ceprag', 0.727, 0.547, 0.968, 1.390, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),


       ('Ceraça', 0.551, 0.419, 0.731, 1.042, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),


       ('Ceral Anitápolis', 0.678, 0.523, 0.888, 1.252, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00',
        '21:30:00', '21:30:00', '22:30:00'),


       ('Ceral Araruama', 1.313, 0.940, 1.815, 2.691, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),


       ('Ceral DIS', 0.649, 0.527, 0.864, 1.202, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),


       ('Cerbranote', 0.591, 0.474, 0.750, 1.206, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00',
        '21:30:00', '21:30:00', '22:30:00'),


       ('CERCI', 1.230, 0.869, 1.717, 2.565, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),


       ('Cercos', 0.915, 0.690, 1.365, 2.040, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00', '20:30:00',
        '20:30:00', '21:30:00'),


       ('Cerej', 0.686, 0.511, 0.922, 1.333, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),


       ('Ceres', 1.272, 0.904, 1.921, 2.939, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),


       ('Cerfox', 0.727, 0.549, 1.232, 2.086, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),


       ('Cergal', 0.785, 0.582, 1.059, 1.537, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),


       ('Cergapa', 0.596, 0.465, 0.772, 1.079, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),


       ('Cergral', 1.313, 0.940, 1.815, 2.691, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),


       ('Ceriluz', 0.596, 0.464, 0.727, 0.990, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),


       ('Cerim', 0.715, 0.517, 0.929, 1.341, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),


       ('Ceripa', 0.712, 0.569, 0.480, 1.159, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('Ceris', 0.787, 0.561, 1.183, 1.806, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00', '20:30:00',
        '20:30:00', '21:30:00'),

       ('CERMC', 0.901, 0.636, 0.971, 1.305, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00', '20:30:00',
        '20:30:00', '21:30:00'),

       ('Cermissões', 0.714, 0.529, 0.899, 1.270, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       ('Cermoful', 0.727, 0.509, 1.021, 1.533, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       ('Cernhe', 0.635, 0.500, 0.770, 1.040, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('Cerpalo', 0.757, 0.496, 1.110, 1.724, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       ('Cerpro', 0.752, 0.600, 0.928, 1.255, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('CERRP', 0.767, 0.592, 0.942, 1.292, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('Cersad', 0.538, 0.441, 0.670, 0.899, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       ('Cersul', 0.499, 0.387, 0.651, 0.916, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       ('Certaja', 0.551, 0.425, 0.743, 1.351, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('Certel', 0.583, 0.491, 0.792, 1.092, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('Certhil', 0.599, 0.458, 0.740, 1.022, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('Certrel', 0.782, 0.537, 1.112, 1.688, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       ('Cervam', 0.623, 0.492, 0.854, 1.217, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00', '20:30:00',
        '20:30:00', '21:30:00'),

       ('Cetril', 0.798, 0.561, 1.054, 1.548, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('Chesp', 0.671, 0.564, 0.783, 1.165, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('Cocel', 0.570, 0.483, 0.674, 1.005, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('Codesam', 0.519, 0.443, 0.622, 0.801, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       ('Coopera', 0.459, 0.369, 0.579, 0.769, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       ('Cooperaliança', 0.573, 0.490, 0.656, 0.971, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00',
        '21:30:00', '21:30:00', '22:30:00'),

       ('Coopercocal', 0.619, 0.468, 0.822, 1.175, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00',
        '21:30:00', '21:30:00', '22:30:00'),

       ('Cooperluz', 0.505, 0.429, 0.575, 0.720, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('Coopermila', 0.533, 0.443, 0.654, 0.865, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00',
        '21:30:00', '21:30:00', '22:30:00'),

       ('Coopernorte', 0.890, 0.685, 1.356, 2.027, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       ('Coopersul', 0.700, 0.613, 0.950, 1.288, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('Cooperzem', 0.643, 0.512, 0.819, 1.126, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       ('Coorsel', 0.627, 0.491, 0.810, 1.129, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       ('Copel-DIS', 0.570, 0.483, 0.674, 1.005, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('Coprel', 0.490, 0.448, 0.697, 0.717, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('CPFL Paulista', 0.662, 0.537, 0.757, 1.156, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       ('CPFL Piratininga', 0.680, 0.568, 0.769, 1.154, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       ('CPFL Santa Cruz(agrupada)', 0.592, 0.482, 0.693, 1.049, '22:00:00', '17:00:00', '17:00:00', '18:00:00',
        '18:00:00', '21:00:00', '21:00:00', '22:00:00'),

       ('Creluz-D', 0.733, 0.584, 1.071, 1.558, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('Creral', 0.767, 0.603, 1.140, 1.677, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('Dcelt', 0.573, 0.490, 0.656, 0.971, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('Demei', 0.681, 0.541, 0.841, 1.290, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('DMED', 0.653, 0.533, 0.818, 1.250, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('EDP ES', 0.674, 0.566, 0.816, 1.225, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('EDP SP', 0.654, 0.530, 0.744, 1.105, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00', '20:30:00',
        '20:30:00', '21:30:00'),

       ('EFLJC', 0.573, 0.490, 0.656, 0.971, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       ('Eflul', 0.573, 0.490, 0.656, 0.971, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00', '21:30:00',
        '21:30:00', '22:30:00'),

       ('Eletrocar', 0.561, 0.418, 0.714, 1.218, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('ELFSM', 0.755, 0.647, 0.961, 1.456, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('Enel CE', 0.709, 0.586, 0.974, 1.534, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00', '20:30:00',
        '20:30:00', '21:30:00'),

       ('Enel GO', 0.671, 0.564, 0.783, 1.165, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('Enel SP', 0.656, 0.541, 0.828, 1.258, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00', '20:30:00',
        '20:30:00', '21:30:00'),

       ('Energisa AC', 0.733, 0.592, 1.030, 1.611, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00',
        '21:30:00', '21:30:00', '22:30:00'),

       ('Energisa MG', 0.766, 0.628, 0.903, 1.374, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       ('Energisa MT', 0.814, 0.654, 1.114, 1.728, '21:30:00', '15:30:00', '15:30:00', '17:30:00', '17:30:00',
        '20:30:00', '20:30:00', '21:30:00'),

       ('Energisa Nova Friburgo', 0.822, 0.638, 0.968, 1.522, '22:00:00', '17:00:00', '17:00:00', '18:00:00',
        '18:00:00', '21:00:00', '21:00:00', '22:00:00'),

       ('Energisa PB', 0.599, 0.497, 0.822, 1.274, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00',
        '20:30:00', '20:30:00', '21:30:00'),

       ('Energisa RO', 0.657, 0.544, 0.880, 1.340, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00',
        '21:30:00', '21:30:00', '22:30:00'),

       ('Energisa SE', 0.646, 0.506, 0.892, 1.416, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00',
        '20:30:00', '20:30:00', '21:30:00'),

       ('Energisa Sul Sudeste', 0.622, 0.535, 0.775, 1.175, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       ('Energisa TO', 0.762, 0.612, 1.097, 1.747, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       ('Equatorial AL', 0.750, 0.633, 1.041, 1.602, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00',
        '20:30:00', '20:30:00', '21:30:00'),

       ('Equatorial MA', 0.651, 0.529, 0.906, 1.415, '22:00:00', '16:00:00', '16:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       ('Equatorial PA', 0.879, 0.682, 1.288, 2.024, '22:30:00', '17:30:00', '17:30:00', '18:30:00', '18:30:00',
        '21:30:00', '21:30:00', '22:30:00'),

       ('Equatorial PI', 0.743, 0.620, 1.069, 1.667, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00',
        '20:30:00', '20:30:00', '21:30:00'),

       ('Forcel', 0.558, 0.444, 0.709, 1.093, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('Hidropan', 0.523, 0.384, 0.636, 1.079, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00', '21:00:00',
        '21:00:00', '22:00:00'),

       ('MuxEnergia', 0.604, 0.439, 0.770, 1.315, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       ('Neonergia Brasília', 0.699, 0.610, 0.777, 1.152, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       ('Neonergia Coelba', 0.746, 0.594, 1.046, 1.656, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       ('Neonergia Cosern', 0.662, 0.549, 0.916, 1.452, '22:00:00', '17:00:00', '17:00:00', '18:00:00', '18:00:00',
        '21:00:00', '21:00:00', '22:00:00'),

       ('Neonergia Elektro', 0.731, 0.613, 0.906, 1.345, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00',
        '20:30:00', '20:30:00', '21:30:00'),

       ('Neonergia Pernambuco', 0.706, 0.601, 0.932, 1.450, '21:30:00', '16:30:00', '16:30:00', '17:30:00', '17:30:00',
        '20:30:00', '20:30:00', '21:30:00');