CREATE TABLE bodega (
    nombrebodega                 VARCHAR2(30) NOT NULL,
    tamanio                      FLOAT(6) NOT NULL,
    sucursal_nombre              VARCHAR2(30) NOT NULL,
    ciudad_codigo                VARCHAR2(30) NOT NULL
);

ALTER TABLE bodega
    ADD CONSTRAINT bodega_pk PRIMARY KEY (nombrebodega, sucursal_nombre, ciudad_codigo);

CREATE TABLE categoria (
    codigocategoria               INTEGER NOT NULL,
    nombrecategoria               VARCHAR2(30) NOT NULL,
    descripcion                   VARCHAR2(50) NOT NULL,
    caracteristicasalmacenamiento VARCHAR2(50) NOT NULL
);

ALTER TABLE categoria ADD CONSTRAINT categoria_pk PRIMARY KEY (codigocategoria);

CREATE TABLE ciudad (
    codigociudad VARCHAR2(30) NOT NULL,
    nombreciudad VARCHAR2(30) NOT NULL
);

ALTER TABLE ciudad ADD CONSTRAINT ciudad_pk PRIMARY KEY (codigociudad);

CREATE TABLE inventarioproducto (
    costopromedio            FLOAT(10) NOT NULL,
    cantidad                 INTEGER NOT NULL,
    capacidad                INTEGER NOT NULL,
    nivelminimoreorden       INTEGER NOT NULL,
    bodega_nombre            VARCHAR2(30) NOT NULL,
    sucursal_nombre          VARCHAR2(30) NOT NULL,
    ciudad_codigo            VARCHAR2(30) NOT NULL,
    producto_codigodebarras  VARCHAR2(10) NOT NULL,
    producto_categoria       INTEGER NOT NULL
);

CREATE UNIQUE INDEX inventarioproducto_idx ON inventarioproducto (producto_codigodebarras ASC, producto_categoria ASC);

ALTER TABLE inventarioproducto
    ADD CONSTRAINT inventarioproducto_pk PRIMARY KEY (bodega_nombre, sucursal_nombre, ciudad_codigo);

CREATE TABLE item (
    cantidad                INTEGER NOT NULL,
    precio                  INTEGER NOT NULL,
    ordendecompra_codigo    INTEGER NOT NULL,
    sucursal_nombre         VARCHAR2(30) NOT NULL,
    ciudad_codigo           VARCHAR2(30) NOT NULL,
    producto_codigodebarras VARCHAR2(10) NOT NULL,
    producto_categoria      INTEGER NOT NULL
);

CREATE UNIQUE INDEX item_idx ON item (producto_codigodebarras ASC, producto_categoria ASC);

ALTER TABLE item
    ADD CONSTRAINT item_pk PRIMARY KEY (ordendecompra_codigo, sucursal_nombre, ciudad_codigo);

CREATE TABLE noperecederos (
    codigocategoria INTEGER NOT NULL
);

ALTER TABLE noperecederos ADD CONSTRAINT noperecederos_pk PRIMARY KEY (codigocategoria);

CREATE TABLE ordendecompra (
    codigo                 INTEGER NOT NULL,
    fechaentrega           DATE NOT NULL,
    fechacreacion          DATE NOT NULL,
    estado                 VARCHAR2(20) NOT NULL,
    sucursal_nombre        VARCHAR2(30) NOT NULL,
    proveedor_nit          VARCHAR2(9) NOT NULL,
    ciudad_codigo          VARCHAR2(30) NOT NULL,
    recepcion_bodega       VARCHAR2(30) NOT NULL,
    recepcion_sucursal     VARCHAR2(30) NOT NULL,
    recepcion_ciudad       VARCHAR2(30) NOT NULL,
    recepcion_id           INTEGER NOT NULL
);

CREATE UNIQUE INDEX ordendecompra_idx ON ordendecompra (recepcion_bodega ASC, recepcion_sucursal ASC, recepcion_ciudad ASC, recepcion_id ASC);

ALTER TABLE ordendecompra
    ADD CONSTRAINT ordendecompra_pk PRIMARY KEY (codigo, sucursal_nombre, ciudad_codigo);

CREATE TABLE perecederos (
    codigocategoria INTEGER NOT NULL,
    fechaexpiracion DATE NOT NULL
);

ALTER TABLE perecederos ADD CONSTRAINT perecederos_pk PRIMARY KEY (codigocategoria);

CREATE TABLE producto (
    codigodebarras       VARCHAR2(10) NOT NULL,
    nombreproducto       VARCHAR2(30) NOT NULL,
    costoenbodega        INTEGER NOT NULL,
    preciounitario       INTEGER NOT NULL,
    presentacion         VARCHAR2(30) NOT NULL,
    cantidadpresentacion INTEGER NOT NULL,
    unidaddemedida       VARCHAR2(20) NOT NULL,
    volumen              FLOAT(6) NOT NULL,
    peso                 FLOAT(6) NOT NULL,
    categoria_codigo     INTEGER NOT NULL
);

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY (codigodebarras, categoria_codigo);

CREATE TABLE proveedor (
    nit              VARCHAR2(9) NOT NULL,
    nombreproveedor  VARCHAR2(30) NOT NULL,
    direccion        VARCHAR2(30) NOT NULL,
    nombrecontacto   VARCHAR2(50) NOT NULL,
    telefonocontacto INTEGER NOT NULL
);

ALTER TABLE proveedor ADD CONSTRAINT proveedor_pk PRIMARY KEY (nit);

CREATE TABLE recepciondeproducto (
    idrecepcion        INTEGER NOT NULL,
    bodega_nombre      VARCHAR2(30) NOT NULL,
    sucursal_nombre    VARCHAR2(30) NOT NULL,
    ciudad_codigo      VARCHAR2(30) NOT NULL,
    ordendecompra_codigo INTEGER NOT NULL,
    ordendecompra_sucursal VARCHAR2(30) NOT NULL,
    ordendecompra_ciudad VARCHAR2(30) NOT NULL
);

CREATE UNIQUE INDEX recepciondeproducto_idx ON recepciondeproducto (ordendecompra_codigo ASC, ordendecompra_sucursal ASC, ordendecompra_ciudad ASC);

ALTER TABLE recepciondeproducto
    ADD CONSTRAINT recepciondeproducto_pk PRIMARY KEY (bodega_nombre, sucursal_nombre, ciudad_codigo, idrecepcion);

CREATE TABLE relation_14 (
    proveedor_nit      VARCHAR2(9) NOT NULL,
    producto_codigodebarras VARCHAR2(10) NOT NULL,
    producto_categoria INTEGER NOT NULL
);

ALTER TABLE relation_14
    ADD CONSTRAINT relation_14_pk PRIMARY KEY (proveedor_nit, producto_codigodebarras, producto_categoria);

CREATE TABLE sucursal (
    nombresucursal VARCHAR2(30) NOT NULL,
    tamanio        FLOAT(6) NOT NULL,
    direccion      VARCHAR2(40) NOT NULL,
    telefono       INTEGER NOT NULL,
    ciudad_codigo  VARCHAR2(30) NOT NULL
);

ALTER TABLE sucursal ADD CONSTRAINT sucursal_pk PRIMARY KEY (nombresucursal, ciudad_codigo);

ALTER TABLE bodega
    ADD CONSTRAINT bodega_sucursal_fk FOREIGN KEY (sucursal_nombre, ciudad_codigo) REFERENCES sucursal (nombresucursal, ciudad_codigo);

ALTER TABLE inventarioproducto
    ADD CONSTRAINT inventarioproducto_bodega_fk FOREIGN KEY (bodega_nombre, sucursal_nombre, ciudad_codigo) REFERENCES bodega (nombrebodega, sucursal_nombre, ciudad_codigo);

ALTER TABLE inventarioproducto
    ADD CONSTRAINT inventarioproducto_producto_fk FOREIGN KEY (producto_codigodebarras, producto_categoria) REFERENCES producto (codigodebarras, categoria_codigo);

ALTER TABLE item
    ADD CONSTRAINT item_ordendecompra_fk FOREIGN KEY (ordendecompra_codigo, sucursal_nombre, ciudad_codigo) REFERENCES ordendecompra (codigo, sucursal_nombre, ciudad_codigo);

ALTER TABLE item
    ADD CONSTRAINT item_producto_fk FOREIGN KEY (producto_codigodebarras, producto_categoria) REFERENCES producto (codigodebarras, categoria_codigo);

ALTER TABLE noperecederos
    ADD CONSTRAINT noperecederos_categoria_fk FOREIGN KEY (codigocategoria) REFERENCES categoria (codigocategoria);

ALTER TABLE ordendecompra
    ADD CONSTRAINT ordendecompra_proveedor_fk FOREIGN KEY (proveedor_nit) REFERENCES proveedor (nit);

ALTER TABLE ordendecompra
    ADD CONSTRAINT ordendecompra_recepcion_fk FOREIGN KEY (recepcion_bodega, recepcion_sucursal, recepcion_ciudad, recepcion_id) REFERENCES recepciondeproducto (bodega_nombre, sucursal_nombre, ciudad_codigo, idrecepcion);

ALTER TABLE ordendecompra
    ADD CONSTRAINT ordendecompra_sucursal_fk FOREIGN KEY (sucursal_nombre, ciudad_codigo) REFERENCES sucursal (nombresucursal, ciudad_codigo);

ALTER TABLE perecederos
    ADD CONSTRAINT perecederos_categoria_fk FOREIGN KEY (codigocategoria) REFERENCES categoria (codigocategoria);

ALTER TABLE producto
    ADD CONSTRAINT producto_categoria_fk FOREIGN KEY (categoria_codigo) REFERENCES categoria (codigocategoria);

ALTER TABLE recepciondeproducto
    ADD CONSTRAINT recepciondeproducto_bodega_fk FOREIGN KEY (bodega_nombre, sucursal_nombre, ciudad_codigo) REFERENCES bodega (nombrebodega, sucursal_nombre, ciudad_codigo);

ALTER TABLE recepciondeproducto
    ADD CONSTRAINT recepciondeproducto_ordcompra_fk FOREIGN KEY (ordendecompra_codigo, ordendecompra_sucursal, ordendecompra_ciudad) REFERENCES ordendecompra (codigo, sucursal_nombre, ciudad_codigo);

ALTER TABLE relation_14
    ADD CONSTRAINT relation_14_producto_fk FOREIGN KEY (producto_codigodebarras, producto_categoria) REFERENCES producto (codigodebarras, categoria_codigo);

ALTER TABLE relation_14
    ADD CONSTRAINT relation_14_proveedor_fk FOREIGN KEY (proveedor_nit) REFERENCES proveedor (nit);

ALTER TABLE sucursal
    ADD CONSTRAINT sucursal_ciudad_fk FOREIGN KEY (ciudad_codigo) REFERENCES ciudad (codigociudad);
