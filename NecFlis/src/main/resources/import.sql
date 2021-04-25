insert into categoria(id, nombre, descripcion, fecha) values (1, 'Series',  'ParaNoSalirDeCasa', '24/4/2020');
insert into categoria(id, nombre, descripcion, fecha) values (2, 'Novelas',  'Dramaticas', '24/4/20');
insert into categoria(id, nombre, descripcion, fecha) values (3, 'Peliculas',  'PasarUnBuenRatoConLaFamilia', '24/12/20');

insert into genero(idg, nombre, descripcion, fecha) values (1, 'Terror',  '+18Años', '24/12/20');
insert into genero(idg, nombre, descripcion, fecha) values (2, 'Comedia',  'TodaLaFamilia', '24/12/20');
insert into genero(idg, nombre, descripcion, fecha) values (3, 'Aprender',  'TodoPublico', '24/12/20');

insert into contenido(idc, nombre, resumen, categoria, genero, fecha) values (1, 'Batman',  'SuperHeroeDcComics', 3, 3, '24/12/20');
insert into contenido(idc, nombre, resumen, categoria, genero, fecha) values (2, 'Dark',  'ViajeEnElTiempo', 1, 1, '24/12/20');
insert into contenido(idc, nombre, resumen, categoria, genero, fecha) values (3, 'PasiónDeGavilanes',  'LaHistoriaDe3Hrmns', 2, 2, '24/12/20');