----- Création de la base de données -----
create database cdpn_fil_rouge owner Utilisateur;

----- Création de la table "utilisateur" -----
create table utilisateur (
	id serial,
	nom varchar(100),
	prenom varchar(100),
	mail varchar(150),
	dateinscription date,
	derniereconnexion timestamp,
	motdepasse varchar(255),
	administrateur boolean,
	constraint pk_utilisateur primary key (id)
);

----- Création de la table "tag" -----
create table tag (
	id serial,
	libelle varchar(150),
	constraint pk_tag primary key (id)
);

----- Création de la table "media" -----
create table media (
	id serial,
	titre varchar(150),
	description varchar(255),
	datecreation timestamp,
	publique boolean,
	publieur integer,
	theme integer,
	constraint pk_media primary key (id),
	constraint fk_media_utilisateur foreign key (publieur) references utilisateur (id),
	constraint fk_media_tag foreign key (theme) references tag (id)
);

----- Création de la table "fichier" -----
create table fichier() inherits(media);

----- Ajout de la clé primaire de la table "fichier" -----
alter table fichier add constraint pk_fichier primary key (id);

----- Ajout de la colonne "cheminfichier" à la table "fichier" -----
alter table fichier add column cheminfichier varchar(255);

----- Création de la table "photo" -----
create table photo() inherits(fichier);

----- Ajout de la clé primaire de la table "fichier" -----
alter table photo add constraint pk_photo primary key (id);

----- Création de la table "musique" -----
create table musique() inherits(fichier);

----- Ajout de la clé primaire de la table "fichier" -----
alter table musique add constraint pk_musique primary key (id);

----- Création de la table "video" -----
create table video() inherits(fichier);

----- Ajout de la clé primaire de la table "fichier" -----
alter table video add constraint pk_video primary key (id);

----- Création de la table "film" -----
create table film() inherits(video);

----- Ajout de la clé primaire de la table "fichier" -----
alter table film add constraint pk_film primary key (id);

----- Ajout de la colonne "realisteur" à la table "film" -----
alter table film add column realisateur varchar(150);

----- Création de la table "episode" -----
create table episode() inherits(video);

----- Ajout de la clé primaire de la table "fichier" -----
alter table episode add constraint pk_episode primary key (id);

----- Ajout de la colonne "numero" à la table "episode" -----
alter table episode add column numero integer;

----- Ajout de la colonne "serie" à la table "episode" -----
alter table episode add column serie varchar(150);

----- Création de la table "playlist" -----
create table playlist() inherits(media);

----- Ajout de la clé primaire de la table "fichier" -----
alter table playlist add constraint pk_playlist primary key (id);

----- Création de la table "galerie" -----
create table galerie() inherits(playlist);

----- Ajout de la clé primaire de la table "fichier" -----
alter table galerie add constraint pk_galerie primary key (id);

----- Création de la table "salle" -----
create table salle (
	id serial,
	nom varchar(150),
	createur integer,
	constraint pk_salle primary key (id),
	constraint fk_salle_utilisateur foreign key (createur) references utilisateur (id)
);

----- Création de la table "contact" -----
create table contact (
	utilisateur1 integer,
	utilisateur2 integer,
	statut varchar(50),
	constraint pk_contact primary key (utilisateur1, utilisateur2),
	constraint fk_contact_utilisateur1 foreign key (utilisateur1) references utilisateur (id),
	constraint fk_contact_utilisateur2 foreign key (utilisateur2) references utilisateur (id)
);

----- Ajout de la règle check pour le statut du contact (demande | acceptée) -----
alter table contact add check (statut in ('en attente', 'valide'));

----- Création de la table "abonnement" -----
create table abonnement (
	publieur integer,
	abonne integer,
	constraint pk_abonnement primary key (publieur, abonne),
	constraint fk_abonnement_publieur foreign key (publieur) references utilisateur (id),
	constraint fk_abonnement_abonne foreign key (abonne) references utilisateur (id)
);

----- Création de la table "contenuplaylist" -----
create table contenuplaylist (
	idplaylist integer,
	idmedia integer,
	constraint pk_contenuplaylist primary key (idplaylist, idmedia),
	constraint fk_contenuplaylist_playlist foreign key (idplaylist) references playlist (id),
	constraint fk_contenuplaylist_media foreign key (idmedia) references media (id)
);

----- Création de la table "contenugalerie" -----
create table contenugalerie (
	galerie integer,
	photo integer,
	constraint pk_contenugalerie primary key (galerie, photo),
	constraint fk_contenugalerie_galerie foreign key (galerie) references galerie (id),
	constraint photo foreign key (photo) references photo (id)
);

----- Création de la table "associationtag"
create table associationtag (
	media integer,
	tag integer,
	constraint pk_associationtag primary key (media, tag),
	constraint fk_associationtag_media foreign key (media) references media (id),
	constraint fk_associationtag_tag foreign key (tag) references tag (id),
);