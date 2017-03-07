-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 30 Jul 2015 pada 04.41
-- Versi Server: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dbcrocodistro`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbbarang`
--

CREATE TABLE IF NOT EXISTS `tbbarang` (
  `kodebarang` varchar(10) NOT NULL,
  `kodemerk` varchar(40) NOT NULL,
  `namabarang` varchar(40) NOT NULL,
  `kodekategori` varchar(40) NOT NULL,
  `harga` int(10) NOT NULL,
  `jumlah` int(10) NOT NULL,
  PRIMARY KEY (`kodebarang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbbarang`
--

INSERT INTO `tbbarang` (`kodebarang`, `kodemerk`, `namabarang`, `kodekategori`, `harga`, `jumlah`) VALUES
('B090', 'GILDAN', 'Sweater', 'ZIPPER HOODIE', 150000, 48);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbbarangmasuk`
--

CREATE TABLE IF NOT EXISTS `tbbarangmasuk` (
  `no_nota` varchar(10) NOT NULL,
  `idbrand` varchar(20) NOT NULL,
  `idpetugas` varchar(45) NOT NULL,
  `tglmasuk` date NOT NULL,
  `total` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbbarangmasuk`
--

INSERT INTO `tbbarangmasuk` (`no_nota`, `idbrand`, `idpetugas`, `tglmasuk`, `total`) VALUES
('N0001', 'CR00Z', 'Nouval Kurnia Firdaus', '2015-07-30', 80000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbbrand`
--

CREATE TABLE IF NOT EXISTS `tbbrand` (
  `idbrand` varchar(20) NOT NULL,
  `namabrand` varchar(40) NOT NULL,
  `alamat` text NOT NULL,
  `email` varchar(40) NOT NULL,
  `telp` varchar(20) NOT NULL,
  PRIMARY KEY (`idbrand`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbbrand`
--

INSERT INTO `tbbrand` (`idbrand`, `namabrand`, `alamat`, `email`, `telp`) VALUES
('CR00Z', 'CROOZ CLOTHING', 'JAKARTA PUSAT', '-', '-');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbdetailbrgmasuk`
--

CREATE TABLE IF NOT EXISTS `tbdetailbrgmasuk` (
  `no_nota` varchar(10) NOT NULL,
  `kodebarang` varchar(20) NOT NULL,
  `jumlah` int(10) NOT NULL,
  `harga` int(10) NOT NULL,
  `subtotal` int(10) NOT NULL,
  `keterangan` varchar(140) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbdetailbrgmasuk`
--

INSERT INTO `tbdetailbrgmasuk` (`no_nota`, `kodebarang`, `jumlah`, `harga`, `subtotal`, `keterangan`) VALUES
('N0001', 'B090', 1, 80000, 80000, '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbdetailpenjualan`
--

CREATE TABLE IF NOT EXISTS `tbdetailpenjualan` (
  `no_faktur` varchar(30) NOT NULL,
  `kodebarang` varchar(20) NOT NULL,
  `jumlah` int(10) NOT NULL,
  `sub` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbdetailpenjualan`
--

INSERT INTO `tbdetailpenjualan` (`no_faktur`, `kodebarang`, `jumlah`, `sub`) VALUES
('06072015.1824.1', 'B090', 1, 150000),
('06072015.1825.1', 'B090', 1, 150000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbhakakses`
--

CREATE TABLE IF NOT EXISTS `tbhakakses` (
  `username` varchar(15) NOT NULL,
  `password` varchar(25) NOT NULL,
  `hakakses` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbhakakses`
--

INSERT INTO `tbhakakses` (`username`, `password`, `hakakses`) VALUES
('novalkrnfds', 'mitrabuana', 'Owner');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbkategori`
--

CREATE TABLE IF NOT EXISTS `tbkategori` (
  `kode` varchar(20) NOT NULL,
  `namakategori` varchar(40) NOT NULL,
  `keterangan` varchar(40) NOT NULL,
  PRIMARY KEY (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbkategori`
--

INSERT INTO `tbkategori` (`kode`, `namakategori`, `keterangan`) VALUES
('K002', 'ZIPPER HOODIE', 'Bahan Baby Terry');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbmerk`
--

CREATE TABLE IF NOT EXISTS `tbmerk` (
  `kode` varchar(20) NOT NULL,
  `namamerk` varchar(40) NOT NULL,
  PRIMARY KEY (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbmerk`
--

INSERT INTO `tbmerk` (`kode`, `namamerk`) VALUES
('M021', 'GILDAN');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbpenjualan`
--

CREATE TABLE IF NOT EXISTS `tbpenjualan` (
  `no_faktur` varchar(30) NOT NULL,
  `tglpenjualan` date NOT NULL,
  `petugas` varchar(35) NOT NULL,
  `total` int(10) NOT NULL,
  `bayar` int(10) NOT NULL,
  `sisa` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbpetugas`
--

CREATE TABLE IF NOT EXISTS `tbpetugas` (
  `idpetugas` int(16) NOT NULL AUTO_INCREMENT,
  `namapetugas` varchar(35) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(40) NOT NULL,
  `hakakses` varchar(15) NOT NULL,
  `jnskelamin` varchar(10) NOT NULL,
  `alamat` text NOT NULL,
  `notelp` varchar(16) NOT NULL,
  PRIMARY KEY (`idpetugas`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2012140958 ;

--
-- Dumping data untuk tabel `tbpetugas`
--

INSERT INTO `tbpetugas` (`idpetugas`, `namapetugas`, `username`, `password`, `hakakses`, `jnskelamin`, `alamat`, `notelp`) VALUES
(1, 'noval', 'noval', '467bae90b19ee6eb379a749cb924f726', 'Admin', 'Pria', '', ''),
(2012140957, 'Nouval Kurnia Firdaus', 'novalkrnfds', '3fa6885ebe0e2646dd825c63b731e65c', 'Karyawan', 'Pria', 'PAMULANGGGGGGGGGGG', '123');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
