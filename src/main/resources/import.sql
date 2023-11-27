insert into cozinha (nome) values ('Panificadora')
insert into cozinha (nome) values ('Hamburgueria');
insert into cozinha (nome) values ('Acaiteria');
insert into cozinha (nome) values ('Tapiocaria')
insert into cozinha (nome) values ('Italiana')
insert into cozinha (nome) values ('Japonesa')

insert into estado (nome) values ('Bahia')
insert into estado (nome) values ('Pernambuco')
insert into estado (nome) values ('Alagoas')
insert into estado (nome) values ('Sergipe')
insert into estado (nome) values ('Ceará')

insert into cidade (nome, estado_id) values ('Conceição do Coité', 1)
insert into cidade (nome, estado_id) values ('Aracaju', 4)
insert into cidade (nome, estado_id) values ('Recife', 2)

insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values ('Sabores dos prazeres', 5.00, 1, utc_timestamp, utc_timestamp, 1, '48730-000', 'Rua Bailon Lopes Carneiro', '555', 'Centro')
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('É Massa', 4.50, 5, utc_timestamp, utc_timestamp)
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Tapiocaria do Hugão', 3.80, 4, utc_timestamp, utc_timestamp)

insert into forma_pagamento (descricao) values ('Em dinheiro')
insert into forma_pagamento (descricao) values ('Pix')
insert into forma_pagamento (descricao) values ('Cartão de crédito')

insert into grupo (nome) values ('Administrador')
insert into grupo (nome) values ('Cliente')
insert into grupo (nome) values ('Desenvolvedor')

insert into usuario (nome, email, senha, data_cadastro) values ('Hugor Parabéns', 'eahugosilva@gmail.com', '999000', utc_timestamp)
insert into usuario (nome, email, senha, data_cadastro) values ('Carol Sorguellis', 'carol123@gmail.com', '123456', utc_timestamp)
insert into usuario (nome, email, senha, data_cadastro) values ('Wells Park', 'tc_wellingtonlima@gmail.com', '102030', utc_timestamp)
insert into usuario (nome, email, senha, data_cadastro) values ('Luany Prechers', 'luah123@gmail.com', '654321', utc_timestamp)

insert into permissao (nome, descricao) values ('CONSULTAR_PRODUTOS', 'Realizar consulta de protudos')
insert into permissao (nome, descricao) values ('CONSULTAR_COZINHAS', 'Realizar consulta de cozinhas')
insert into permissao (nome, descricao) values ('EDITAR_COZINHAS', 'Consultar e editar cozinhas')
insert into permissao (nome, descricao) values ('ACESSO_CODIGO_FONTE', 'Consultar e editar o código fonte')

insert into produto (nome, descricao, preco, restaurante_id, ativo) values ('Torta de limão', 'Torta feita com mousse de limão e massa Pâte Sablée', 6.35, 1, true)
insert into produto (nome, descricao, preco, restaurante_id, ativo) values ('Penne à Bolonhesa', 'Massa pene com carne moída', 15.99, 2, true)
insert into produto (nome, descricao, preco, restaurante_id, ativo) values ('Espaquete à Carbonara', 'Massa espaquete com molho de queijo e ovo', 15.99, 2, true)
insert into produto (nome, descricao, preco, restaurante_id, ativo) values ('Tapioca Nordestina', 'Tapioca com carne do sol e banana da terra', 9.80, 3, false)

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3)

insert into grupo_permissao (grupo_id, permissao_id) values (1, 3), (2, 1), (2, 2), (3, 4)

insert into usuario_grupo (usuario_id, grupo_id) values (1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (3, 2), (4, 2)


