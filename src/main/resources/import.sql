INSERT INTO especialidade (nome) values ('Cardiologia');
INSERT INTO especialidade (nome) values ('Dermatologia');
INSERT INTO especialidade (nome) values ('Pediatria');
INSERT INTO especialidade (nome) values ('Cirurgia Plástica');
INSERT INTO tb_pessoa (tipo, nome, crm) VALUES ('M', 'Dra. Ana', '78901');
INSERT INTO tb_pessoa (tipo, nome, telefone) VALUES ('P', 'Pedro Santos', '9988776655');
INSERT INTO tb_pessoa (tipo, nome, crm) VALUES ('M', 'Dr. Paula', '45678');
INSERT INTO tb_pessoa (tipo, nome, telefone) VALUES ('P', 'Luana Pereira', '9876543210');
INSERT INTO tb_pessoa (tipo, nome, crm) VALUES ('M', 'Dr. Rafael', '87654');
INSERT INTO tb_pessoa (tipo, nome, telefone) VALUES ('P', 'Fernanda Alves', '9588451122');
INSERT INTO tb_pessoa (tipo, nome, crm) VALUES ('M', 'Dr. Vanessa', '23456');
INSERT INTO tb_pessoa (tipo, nome, telefone) VALUES ('P', 'Ricardo Lima', '9421451122');
INSERT INTO tb_pessoa (tipo, nome, crm) VALUES ('M', 'Dr. Camila', '76543');
INSERT INTO tb_pessoa (tipo, nome, telefone) VALUES ('P', 'Gustavo Silva', '8849851122');
INSERT INTO medico_especialidade (especialidade_id, medico_id) values (1, 1);
INSERT INTO medico_especialidade (especialidade_id, medico_id) values (2, 3);
INSERT INTO medico_especialidade (especialidade_id, medico_id) values (3, 5);
INSERT INTO medico_especialidade (especialidade_id, medico_id) values (4, 7);
INSERT INTO medico_especialidade (especialidade_id, medico_id) values (1, 9);
INSERT INTO consulta (data, valor, observacao, medico_id, paciente_id) VALUES ('2023-09-25 16:00:00', 180.00, 'Consulta de acompanhamento', 1, 2);
INSERT INTO consulta (data, valor, observacao, medico_id, paciente_id) VALUES ('2023-10-15 14:30:00', 200.00, 'Consulta Mensal', 3, 4);
INSERT INTO consulta (data, valor, observacao, medico_id, paciente_id) VALUES ('2023-11-05 11:00:00', 220.00, 'Consulta de rotina', 5, 6);
INSERT INTO consulta (data, valor, observacao, medico_id, paciente_id) VALUES ('2023-12-20 10:15:00', 250.00, 'Consulta de avaliação', 7, 8);
INSERT INTO consulta (data, valor, observacao, medico_id, paciente_id) VALUES ('2023-09-10 09:30:00', 160.00, 'Consulta de rotina', 9, 10);
INSERT INTO usuario (login, password) VALUES ('cris', '$2a$10$zbAOpayv22A4AkgA0TslKO7slzt8lrnRih8mGseulvBUyYS/GloV.')
INSERT INTO usuario (login, password) VALUES ('joao', '$2a$10$zbAOpayv22A4AkgA0TslKO7slzt8lrnRih8mGseulvBUyYS/GloV.')
INSERT INTO usuario (login, password) VALUES ('adrian', '$2a$10$zbAOpayv22A4AkgA0TslKO7slzt8lrnRih8mGseulvBUyYS/GloV.')
INSERT INTO role (nome) values ('ROLE_MEDICO')
INSERT INTO role (nome) values ('ROLE_ASSISTENTE')
INSERT INTO role (nome) values ('ROLE_ADMINISTRADOR')
INSERT INTO usuario_role (role_id, usuario_id) values (1,1)
INSERT INTO usuario_role (role_id, usuario_id) values (2,2)
INSERT INTO usuario_role (role_id, usuario_id) values (3,3)
INSERT INTO test.horario (disponivel, inicio, fim, dia, id) VALUES (true, '09:00:00', '10:00:00', null, 2);
INSERT INTO test.horario (disponivel, inicio, fim, dia, id) VALUES (true, '10:00:00', '11:00:00', null, 3);
INSERT INTO test.horario (disponivel, inicio, fim, dia, id) VALUES (true, '11:00:00', '12:00:00', null, 4);
INSERT INTO test.horario (disponivel, inicio, fim, dia, id) VALUES (true, '14:00:00', '15:00:00', null, 5);
INSERT INTO test.horario (disponivel, inicio, fim, dia, id) VALUES (true, '16:00:00', '17:00:00', null, 6);
INSERT INTO test.horario (disponivel, inicio, fim, dia, id) VALUES (true, '17:00:00', '18:00:00', null, 7);


