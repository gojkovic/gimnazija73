-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 12, 2018 at 10:48 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gimnazija`
--

-- --------------------------------------------------------

--
-- Table structure for table `angazovanje`
--

CREATE TABLE `angazovanje` (
  `angazovanje_id` bigint(20) NOT NULL,
  `kraj` date NOT NULL,
  `pocetak` date NOT NULL,
  `nastavni_plan_predmet_id` bigint(20) NOT NULL,
  `nastavnik_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `angazovanje_odeljenje`
--

CREATE TABLE `angazovanje_odeljenje` (
  `odeljenje_id` bigint(20) NOT NULL,
  `angazovanje_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `cas`
--

CREATE TABLE `cas` (
  `cas_id` bigint(20) NOT NULL,
  `datum_unosa` date NOT NULL,
  `napomena` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opis_casa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `redni_broj_casa` int(11) DEFAULT NULL,
  `ukupan_rb_casa` int(11) DEFAULT NULL,
  `nastavni_plan_predmet_id` bigint(20) NOT NULL,
  `nastavnik_id` bigint(20) NOT NULL,
  `odeljenje_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `cenovnik`
--

CREATE TABLE `cenovnik` (
  `cenovnik_id` bigint(20) NOT NULL,
  `cena_stavke` float DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date NOT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `naziv_stavke` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sifra_stavke` int(11) DEFAULT NULL,
  `valuta` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modeli_placanja_i_stipendije_id` bigint(20) NOT NULL,
  `skolska_godina_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `godisnji_plan`
--

CREATE TABLE `godisnji_plan` (
  `godisnji_plan_id` bigint(20) NOT NULL,
  `datum_usvajanja` date NOT NULL,
  `naziv_skole` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `usvojen` int(11) DEFAULT NULL,
  `vazi_do` date NOT NULL,
  `skolska_godina_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `godisnji_plan`
--

INSERT INTO `godisnji_plan` (`godisnji_plan_id`, `datum_usvajanja`, `naziv_skole`, `usvojen`, `vazi_do`, `skolska_godina_id`) VALUES
(1, '2018-10-10', 'Metropolitan gimnazija', 0, '2019-07-15', 1);

-- --------------------------------------------------------

--
-- Table structure for table `modeli_placanja_i_stipendije`
--

CREATE TABLE `modeli_placanja_i_stipendije` (
  `modeli_placanja_i_stipendije_id` bigint(20) NOT NULL,
  `kamata` double DEFAULT NULL,
  `naziv_modela` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opis` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `popust` double DEFAULT NULL,
  `zatezna_kamata` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nastavnik`
--

CREATE TABLE `nastavnik` (
  `nastavniki_id` bigint(20) NOT NULL,
  `fakultet` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `razredni` int(11) DEFAULT NULL,
  `zaposleni_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nastavni_plan_predmet`
--

CREATE TABLE `nastavni_plan_predmet` (
  `nastavni_plan_predmet_id` bigint(20) NOT NULL,
  `ime_plana` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nedeljno_nastave` int(11) DEFAULT NULL,
  `nedeljno_vezbi` int(11) DEFAULT NULL,
  `razred` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ukupno_nedelja` int(11) DEFAULT NULL,
  `godisnji_plan_id` bigint(20) NOT NULL,
  `predmet_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nastavni_plan_predmet`
--

INSERT INTO `nastavni_plan_predmet` (`nastavni_plan_predmet_id`, `ime_plana`, `nedeljno_nastave`, `nedeljno_vezbi`, `razred`, `ukupno_nedelja`, `godisnji_plan_id`, `predmet_id`) VALUES
(1, 'adfgrg', 5, 5, 'da', 5, 1, 1),
(2, 'Plan2', 8, 2, '1/2', 40, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `odeljenje`
--

CREATE TABLE `odeljenje` (
  `odeljenje_id` bigint(20) NOT NULL,
  `oznaka` int(11) DEFAULT NULL,
  `razred` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nastavnik_id` bigint(20) NOT NULL,
  `skolska_godina_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `predmet`
--

CREATE TABLE `predmet` (
  `predmet_id` bigint(20) NOT NULL,
  `pun_naziv` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sifra` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `predmet`
--

INSERT INTO `predmet` (`predmet_id`, `pun_naziv`, `sifra`) VALUES
(1, 'Uvod u objektno-orijentisano programiranje', 'CS101'),
(2, 'Osnove informacionih tehnologija', 'IT101'),
(3, 'Matematika za IT', 'MA103'),
(4, 'Engleski 1', 'NT111'),
(5, 'Objekti i apstrakcija podataka', 'CS102'),
(6, 'Sistemi informacionih tehnologija', 'IT210'),
(7, 'C/C++ programski jezik', 'CS323'),
(8, 'Engleski 2', 'NT112');

-- --------------------------------------------------------

--
-- Table structure for table `prisustvo`
--

CREATE TABLE `prisustvo` (
  `prisustvo_id` bigint(20) NOT NULL,
  `opravdano` int(11) DEFAULT NULL,
  `cas_id` bigint(20) NOT NULL,
  `ucenik_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `roditelj`
--

CREATE TABLE `roditelj` (
  `roditelj_id` bigint(20) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `roditeljski_sastanak`
--

CREATE TABLE `roditeljski_sastanak` (
  `roditeljski_sastanak_id` bigint(20) NOT NULL,
  `datum` date NOT NULL,
  `napomena` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `roditelj_id` bigint(20) NOT NULL,
  `zaposleni_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `naziv_role` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `naziv_role`) VALUES
(1, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `skolska_godina`
--

CREATE TABLE `skolska_godina` (
  `skolska_godina_id` bigint(20) NOT NULL,
  `datum_kraja` date NOT NULL,
  `datum_pocetka` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `skolska_godina`
--

INSERT INTO `skolska_godina` (`skolska_godina_id`, `datum_kraja`, `datum_pocetka`) VALUES
(1, '2018-09-01', '2019-06-15');

-- --------------------------------------------------------

--
-- Table structure for table `ucenik`
--

CREATE TABLE `ucenik` (
  `ucenik_id` bigint(20) NOT NULL,
  `broj_knjizice` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ime_roditelja` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `osnovna_skola` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ucenik_predmet`
--

CREATE TABLE `ucenik_predmet` (
  `ucenik_predmet_id` bigint(20) NOT NULL,
  `datum_unosa` date NOT NULL,
  `napomena` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ocena` int(11) DEFAULT NULL,
  `polugodiste` int(11) DEFAULT NULL,
  `tip_ocene` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nastavni_plan_predmet_id` bigint(20) NOT NULL,
  `nastavnik_id` bigint(20) NOT NULL,
  `ucenik_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ucenik_roditelj`
--

CREATE TABLE `ucenik_roditelj` (
  `roditelj_id` bigint(20) NOT NULL,
  `ucenik_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `upis`
--

CREATE TABLE `upis` (
  `upis_id` bigint(20) NOT NULL,
  `datum_upisa` date NOT NULL,
  `odeljenje_id` bigint(20) NOT NULL,
  `ucenik_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `uplate`
--

CREATE TABLE `uplate` (
  `uplate_id` bigint(20) NOT NULL,
  `datum_placanja` date NOT NULL,
  `iznos_uplate_din` float DEFAULT NULL,
  `iznos_uplate_eur` float DEFAULT NULL,
  `napomena` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `srednji_kurs` float DEFAULT NULL,
  `zaduzenja_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `adresa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `datum_rodjenja` datetime DEFAULT NULL,
  `display_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `grad` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `jmbg` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ldapcn` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `telefon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `active`, `adresa`, `datum_rodjenja`, `display_name`, `email`, `grad`, `jmbg`, `last_name`, `ldapcn`, `name`, `password`, `telefon`, `user_name`) VALUES
(1, 1, NULL, NULL, NULL, 'ag.gojkovic@gmail.com', NULL, NULL, 'Gojkovic', NULL, 'Aleksandar', '$2a$10$wBfu8wFq.4js8aUkgzO84.LYioXlfZMR1RfXUWP8hzDQC5w5W5bxK', NULL, 'Aleksandar');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `zaduzenja`
--

CREATE TABLE `zaduzenja` (
  `zaduzenja_id` bigint(20) NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` datetime DEFAULT NULL,
  `viznos_zaduzenja` double DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `napomena` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `popust_iznos` double DEFAULT NULL,
  `rok_za_placanje` date NOT NULL,
  `cenovnik_id` bigint(20) NOT NULL,
  `upis_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `zaposleni`
--

CREATE TABLE `zaposleni` (
  `zaposleni_id` bigint(20) NOT NULL,
  `sss` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `banka` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `broj_racuna` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pozicija` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `zvanje` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `angazovanje`
--
ALTER TABLE `angazovanje`
  ADD PRIMARY KEY (`angazovanje_id`),
  ADD KEY `FKjoc3q9wsqtg0su4y0rwdoo2e5` (`nastavni_plan_predmet_id`),
  ADD KEY `FK89oi2ih6nr00ydg4x82vkdu3s` (`nastavnik_id`);

--
-- Indexes for table `angazovanje_odeljenje`
--
ALTER TABLE `angazovanje_odeljenje`
  ADD PRIMARY KEY (`angazovanje_id`,`odeljenje_id`),
  ADD KEY `FKrchneq3wo5m2snhgcoww3yy2d` (`odeljenje_id`);

--
-- Indexes for table `cas`
--
ALTER TABLE `cas`
  ADD PRIMARY KEY (`cas_id`),
  ADD KEY `FKppwrqmsdcw3orqd8rlwqli5b1` (`nastavni_plan_predmet_id`),
  ADD KEY `FKkog0bmuq8avixtiplhrdwnu6e` (`nastavnik_id`),
  ADD KEY `FK41kmmqws74e6ge3rm0rvugnme` (`odeljenje_id`);

--
-- Indexes for table `cenovnik`
--
ALTER TABLE `cenovnik`
  ADD PRIMARY KEY (`cenovnik_id`),
  ADD KEY `FKia0amtr3svmajpu387hl50ble` (`modeli_placanja_i_stipendije_id`),
  ADD KEY `FK4rju2amp2tce0aemvqbbjdy6g` (`skolska_godina_id`);

--
-- Indexes for table `godisnji_plan`
--
ALTER TABLE `godisnji_plan`
  ADD PRIMARY KEY (`godisnji_plan_id`),
  ADD KEY `FKd9hk9prxkwnbctwasownvxnwa` (`skolska_godina_id`);

--
-- Indexes for table `modeli_placanja_i_stipendije`
--
ALTER TABLE `modeli_placanja_i_stipendije`
  ADD PRIMARY KEY (`modeli_placanja_i_stipendije_id`);

--
-- Indexes for table `nastavnik`
--
ALTER TABLE `nastavnik`
  ADD PRIMARY KEY (`nastavniki_id`),
  ADD KEY `FKtexdksvi6tfa6dbeymiipn2cp` (`zaposleni_id`);

--
-- Indexes for table `nastavni_plan_predmet`
--
ALTER TABLE `nastavni_plan_predmet`
  ADD PRIMARY KEY (`nastavni_plan_predmet_id`),
  ADD KEY `FK19pc8ynuge0ichx2oiih4415m` (`godisnji_plan_id`),
  ADD KEY `FKnph681fxsfs11jvkyosp7lbms` (`predmet_id`);

--
-- Indexes for table `odeljenje`
--
ALTER TABLE `odeljenje`
  ADD PRIMARY KEY (`odeljenje_id`),
  ADD KEY `FKg91yw1a366tcriqx88m0ggbur` (`nastavnik_id`),
  ADD KEY `FKnbb1ni0dewr60l2piq5ce64fq` (`skolska_godina_id`);

--
-- Indexes for table `predmet`
--
ALTER TABLE `predmet`
  ADD PRIMARY KEY (`predmet_id`);

--
-- Indexes for table `prisustvo`
--
ALTER TABLE `prisustvo`
  ADD PRIMARY KEY (`prisustvo_id`),
  ADD KEY `FKa65yshvn1l3djwdgrhwbc0iuy` (`cas_id`),
  ADD KEY `FKhjm5danln355efeashui09q24` (`ucenik_id`);

--
-- Indexes for table `roditelj`
--
ALTER TABLE `roditelj`
  ADD PRIMARY KEY (`roditelj_id`),
  ADD KEY `FKd9nk3ma07b4p7jyj8p3i655bw` (`user_id`);

--
-- Indexes for table `roditeljski_sastanak`
--
ALTER TABLE `roditeljski_sastanak`
  ADD PRIMARY KEY (`roditeljski_sastanak_id`),
  ADD KEY `FK1fw2ea1s84fauu8sgmdu7fkt3` (`roditelj_id`),
  ADD KEY `FKld7fmol9i2tsc4ffpr9fh8edj` (`zaposleni_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `skolska_godina`
--
ALTER TABLE `skolska_godina`
  ADD PRIMARY KEY (`skolska_godina_id`);

--
-- Indexes for table `ucenik`
--
ALTER TABLE `ucenik`
  ADD PRIMARY KEY (`ucenik_id`),
  ADD KEY `FKlnq36u5o7v78vvke2al6by4tg` (`user_id`);

--
-- Indexes for table `ucenik_predmet`
--
ALTER TABLE `ucenik_predmet`
  ADD PRIMARY KEY (`ucenik_predmet_id`),
  ADD KEY `FKdq1lioiakfmduxo6do09gt9u1` (`nastavni_plan_predmet_id`),
  ADD KEY `FKkg9ryxf5nknlns964rxh41uwt` (`nastavnik_id`),
  ADD KEY `FK6e9jtymx1q4c8kn3mk7k1l4hp` (`ucenik_id`);

--
-- Indexes for table `ucenik_roditelj`
--
ALTER TABLE `ucenik_roditelj`
  ADD PRIMARY KEY (`ucenik_id`,`roditelj_id`),
  ADD KEY `FKltiglhswstocbnj1qqxtf82of` (`roditelj_id`);

--
-- Indexes for table `upis`
--
ALTER TABLE `upis`
  ADD PRIMARY KEY (`upis_id`),
  ADD KEY `FKikxdpyeen096w9ow7fl5t9kq8` (`odeljenje_id`),
  ADD KEY `FKlla640ivy28cpgpvvgnu8ebha` (`ucenik_id`);

--
-- Indexes for table `uplate`
--
ALTER TABLE `uplate`
  ADD PRIMARY KEY (`uplate_id`),
  ADD KEY `FKrdq878e3k1c16o9d68n93nkjy` (`zaduzenja_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`);

--
-- Indexes for table `zaduzenja`
--
ALTER TABLE `zaduzenja`
  ADD PRIMARY KEY (`zaduzenja_id`),
  ADD KEY `FKlscd7hjq8mt183fehcq5sjty4` (`cenovnik_id`),
  ADD KEY `FKtlfyjecs7r8lj3p6j88mfixco` (`upis_id`);

--
-- Indexes for table `zaposleni`
--
ALTER TABLE `zaposleni`
  ADD PRIMARY KEY (`zaposleni_id`),
  ADD KEY `FK62tqfx6l9i2y14hus1qmwbc4x` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `angazovanje`
--
ALTER TABLE `angazovanje`
  MODIFY `angazovanje_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cas`
--
ALTER TABLE `cas`
  MODIFY `cas_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cenovnik`
--
ALTER TABLE `cenovnik`
  MODIFY `cenovnik_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `godisnji_plan`
--
ALTER TABLE `godisnji_plan`
  MODIFY `godisnji_plan_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `modeli_placanja_i_stipendije`
--
ALTER TABLE `modeli_placanja_i_stipendije`
  MODIFY `modeli_placanja_i_stipendije_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nastavnik`
--
ALTER TABLE `nastavnik`
  MODIFY `nastavniki_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nastavni_plan_predmet`
--
ALTER TABLE `nastavni_plan_predmet`
  MODIFY `nastavni_plan_predmet_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `odeljenje`
--
ALTER TABLE `odeljenje`
  MODIFY `odeljenje_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `predmet`
--
ALTER TABLE `predmet`
  MODIFY `predmet_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `prisustvo`
--
ALTER TABLE `prisustvo`
  MODIFY `prisustvo_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `roditelj`
--
ALTER TABLE `roditelj`
  MODIFY `roditelj_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `roditeljski_sastanak`
--
ALTER TABLE `roditeljski_sastanak`
  MODIFY `roditeljski_sastanak_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `skolska_godina`
--
ALTER TABLE `skolska_godina`
  MODIFY `skolska_godina_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `ucenik`
--
ALTER TABLE `ucenik`
  MODIFY `ucenik_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ucenik_predmet`
--
ALTER TABLE `ucenik_predmet`
  MODIFY `ucenik_predmet_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `upis`
--
ALTER TABLE `upis`
  MODIFY `upis_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `uplate`
--
ALTER TABLE `uplate`
  MODIFY `uplate_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `zaduzenja`
--
ALTER TABLE `zaduzenja`
  MODIFY `zaduzenja_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `zaposleni`
--
ALTER TABLE `zaposleni`
  MODIFY `zaposleni_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `angazovanje`
--
ALTER TABLE `angazovanje`
  ADD CONSTRAINT `FK89oi2ih6nr00ydg4x82vkdu3s` FOREIGN KEY (`nastavnik_id`) REFERENCES `nastavnik` (`nastavniki_id`),
  ADD CONSTRAINT `FKjoc3q9wsqtg0su4y0rwdoo2e5` FOREIGN KEY (`nastavni_plan_predmet_id`) REFERENCES `nastavni_plan_predmet` (`nastavni_plan_predmet_id`);

--
-- Constraints for table `angazovanje_odeljenje`
--
ALTER TABLE `angazovanje_odeljenje`
  ADD CONSTRAINT `FKpp2dfpw5p76wytd1lc01sfh9i` FOREIGN KEY (`angazovanje_id`) REFERENCES `angazovanje` (`angazovanje_id`),
  ADD CONSTRAINT `FKrchneq3wo5m2snhgcoww3yy2d` FOREIGN KEY (`odeljenje_id`) REFERENCES `odeljenje` (`odeljenje_id`);

--
-- Constraints for table `cas`
--
ALTER TABLE `cas`
  ADD CONSTRAINT `FK41kmmqws74e6ge3rm0rvugnme` FOREIGN KEY (`odeljenje_id`) REFERENCES `odeljenje` (`odeljenje_id`),
  ADD CONSTRAINT `FKkog0bmuq8avixtiplhrdwnu6e` FOREIGN KEY (`nastavnik_id`) REFERENCES `nastavnik` (`nastavniki_id`),
  ADD CONSTRAINT `FKppwrqmsdcw3orqd8rlwqli5b1` FOREIGN KEY (`nastavni_plan_predmet_id`) REFERENCES `nastavni_plan_predmet` (`nastavni_plan_predmet_id`);

--
-- Constraints for table `cenovnik`
--
ALTER TABLE `cenovnik`
  ADD CONSTRAINT `FK4rju2amp2tce0aemvqbbjdy6g` FOREIGN KEY (`skolska_godina_id`) REFERENCES `skolska_godina` (`skolska_godina_id`),
  ADD CONSTRAINT `FKia0amtr3svmajpu387hl50ble` FOREIGN KEY (`modeli_placanja_i_stipendije_id`) REFERENCES `modeli_placanja_i_stipendije` (`modeli_placanja_i_stipendije_id`);

--
-- Constraints for table `godisnji_plan`
--
ALTER TABLE `godisnji_plan`
  ADD CONSTRAINT `FKd9hk9prxkwnbctwasownvxnwa` FOREIGN KEY (`skolska_godina_id`) REFERENCES `skolska_godina` (`skolska_godina_id`);

--
-- Constraints for table `nastavnik`
--
ALTER TABLE `nastavnik`
  ADD CONSTRAINT `FKtexdksvi6tfa6dbeymiipn2cp` FOREIGN KEY (`zaposleni_id`) REFERENCES `zaposleni` (`zaposleni_id`);

--
-- Constraints for table `nastavni_plan_predmet`
--
ALTER TABLE `nastavni_plan_predmet`
  ADD CONSTRAINT `FK19pc8ynuge0ichx2oiih4415m` FOREIGN KEY (`godisnji_plan_id`) REFERENCES `godisnji_plan` (`godisnji_plan_id`),
  ADD CONSTRAINT `FKnph681fxsfs11jvkyosp7lbms` FOREIGN KEY (`predmet_id`) REFERENCES `predmet` (`predmet_id`);

--
-- Constraints for table `odeljenje`
--
ALTER TABLE `odeljenje`
  ADD CONSTRAINT `FKg91yw1a366tcriqx88m0ggbur` FOREIGN KEY (`nastavnik_id`) REFERENCES `nastavnik` (`nastavniki_id`),
  ADD CONSTRAINT `FKnbb1ni0dewr60l2piq5ce64fq` FOREIGN KEY (`skolska_godina_id`) REFERENCES `skolska_godina` (`skolska_godina_id`);

--
-- Constraints for table `prisustvo`
--
ALTER TABLE `prisustvo`
  ADD CONSTRAINT `FKa65yshvn1l3djwdgrhwbc0iuy` FOREIGN KEY (`cas_id`) REFERENCES `cas` (`cas_id`),
  ADD CONSTRAINT `FKhjm5danln355efeashui09q24` FOREIGN KEY (`ucenik_id`) REFERENCES `ucenik` (`ucenik_id`);

--
-- Constraints for table `roditelj`
--
ALTER TABLE `roditelj`
  ADD CONSTRAINT `FKd9nk3ma07b4p7jyj8p3i655bw` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `roditeljski_sastanak`
--
ALTER TABLE `roditeljski_sastanak`
  ADD CONSTRAINT `FK1fw2ea1s84fauu8sgmdu7fkt3` FOREIGN KEY (`roditelj_id`) REFERENCES `roditelj` (`roditelj_id`),
  ADD CONSTRAINT `FKld7fmol9i2tsc4ffpr9fh8edj` FOREIGN KEY (`zaposleni_id`) REFERENCES `zaposleni` (`zaposleni_id`);

--
-- Constraints for table `ucenik`
--
ALTER TABLE `ucenik`
  ADD CONSTRAINT `FKlnq36u5o7v78vvke2al6by4tg` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `ucenik_predmet`
--
ALTER TABLE `ucenik_predmet`
  ADD CONSTRAINT `FK6e9jtymx1q4c8kn3mk7k1l4hp` FOREIGN KEY (`ucenik_id`) REFERENCES `ucenik` (`ucenik_id`),
  ADD CONSTRAINT `FKdq1lioiakfmduxo6do09gt9u1` FOREIGN KEY (`nastavni_plan_predmet_id`) REFERENCES `nastavni_plan_predmet` (`nastavni_plan_predmet_id`),
  ADD CONSTRAINT `FKkg9ryxf5nknlns964rxh41uwt` FOREIGN KEY (`nastavnik_id`) REFERENCES `nastavnik` (`nastavniki_id`);

--
-- Constraints for table `ucenik_roditelj`
--
ALTER TABLE `ucenik_roditelj`
  ADD CONSTRAINT `FKltiglhswstocbnj1qqxtf82of` FOREIGN KEY (`roditelj_id`) REFERENCES `roditelj` (`roditelj_id`),
  ADD CONSTRAINT `FKpgqhnga7w71n5hfla7ku2a3bl` FOREIGN KEY (`ucenik_id`) REFERENCES `ucenik` (`ucenik_id`);

--
-- Constraints for table `upis`
--
ALTER TABLE `upis`
  ADD CONSTRAINT `FKikxdpyeen096w9ow7fl5t9kq8` FOREIGN KEY (`odeljenje_id`) REFERENCES `odeljenje` (`odeljenje_id`),
  ADD CONSTRAINT `FKlla640ivy28cpgpvvgnu8ebha` FOREIGN KEY (`ucenik_id`) REFERENCES `ucenik` (`ucenik_id`);

--
-- Constraints for table `uplate`
--
ALTER TABLE `uplate`
  ADD CONSTRAINT `FKrdq878e3k1c16o9d68n93nkjy` FOREIGN KEY (`zaduzenja_id`) REFERENCES `zaduzenja` (`zaduzenja_id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);

--
-- Constraints for table `zaduzenja`
--
ALTER TABLE `zaduzenja`
  ADD CONSTRAINT `FKlscd7hjq8mt183fehcq5sjty4` FOREIGN KEY (`cenovnik_id`) REFERENCES `cenovnik` (`cenovnik_id`),
  ADD CONSTRAINT `FKtlfyjecs7r8lj3p6j88mfixco` FOREIGN KEY (`upis_id`) REFERENCES `upis` (`upis_id`);

--
-- Constraints for table `zaposleni`
--
ALTER TABLE `zaposleni`
  ADD CONSTRAINT `FK62tqfx6l9i2y14hus1qmwbc4x` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
