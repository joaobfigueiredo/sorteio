CREATE SCHEMA `sorteios` ;

CREATE TABLE `authorities` (
  `username` varchar(20) NOT NULL DEFAULT '',
  `authority` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`username`,`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



ALTER TABLE `sorteio`.`users` 
CHANGE COLUMN `password` `password` VARCHAR(255) CHARACTER SET 'ascii' NULL DEFAULT NULL ;


INSERT INTO `sorteio`.`users` (`username`, `enabled`, `password`) VALUES ('joao', b'1', '$2a$10$FrW51lDI6K81F.pxfMDcTeG8i6a.hKQcGLsWYqk6sbVstbPXD9dxe');
INSERT INTO `sorteio`.`authorities` (`username`, `authority`) VALUES ('joao', 'ROLE_ADM');