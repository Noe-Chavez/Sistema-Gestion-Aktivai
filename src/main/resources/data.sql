-- Inserciones para usuarios.
INSERT INTO `usuarios` (`id_usuario`, `usuario`, `password`, `email`, `estatus`, `avatar`) VALUES
(1, 'Shampoo San China', 'nada,nada,nada,nada,nada,nada,nada,nada', 'prueba@pruebas.com', 1, NULL),
(2, 'Akane Tendo', 'pechan_dos_3,pechan_dos_3', 'correoficticio@ficticioemail.com', 1, NULL),
(3, 'Naviki Tendo', 'abiciosa,abiciosa', 'prueba@pruebas.com', 1, NULL),
(4, 'Lucas Martinez López', 'lopex123', 'prueba@pruebas.com', 1, NULL),
(5, 'Kuno Tatewaki', 'kunmo12a3', 'prueba@pruebas2.com', 1, NULL),
(6, 'Kasumki Tendo', 'kasumi123,kasumi123', 'prueba@pruebas.com', 1, NULL);

-- Inserciones para Roles.
INSERT INTO `roles` (`id_rol`, `rol`, `descripcion`) VALUES
(1, 'Ventas', 'Realizar labor de venta de productos y servicios.'),
(2, 'Instalador', 'Realizar labor de instalación de equipos y configuraciones de éstos'),
(3, 'Cobranza', 'Realizar labor de cobros y la gestión de pagos de los clientes.'),
(4, 'Soporte/Ingeniería', 'Realizar labor de soporte técnico y configuración de servicios. Atender tikets de fallos en general.'),
(5, 'Administrador', 'Encargado de adminsitrar sistema de infromación. Acceso a todos los niveles'),
(6, 'Cliente', 'cliente, persona física o moral a quien se le prestan servicios. Contratante');

-- Inserciones para usaurio_roles
INSERT INTO `usuarios_roles` (`usuario_id`, `rol_id`) VALUES
(1, 1),
(2, 2),
(3, 6),
(4, 5),
(5, 2),
(6, 3);