-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 14, 2023 at 04:33 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `transportation`
--

-- --------------------------------------------------------

--
-- Table structure for table `att`
--

CREATE TABLE `att` (
  `id` int(20) NOT NULL,
  `flag` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `att`
--

INSERT INTO `att` (`id`, `flag`) VALUES
(1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `dr_no` bigint(20) NOT NULL,
  `days` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`dr_no`, `days`) VALUES
(1, 3),
(2, 3),
(3, 3),
(4, 2),
(5, 3),
(6, 3),
(7, 3),
(8, 3),
(9, 2),
(11, 2),
(12, 1);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `c_no` bigint(20) NOT NULL,
  `c_name` text NOT NULL,
  `c_addr` text NOT NULL,
  `c_phone_no` text NOT NULL,
  `front_party_name` text NOT NULL,
  `front_party_addr` text NOT NULL,
  `front_party_phone_no` text NOT NULL,
  `i_name` text NOT NULL,
  `quantity` bigint(20) NOT NULL,
  `rate` bigint(20) NOT NULL,
  `total_amount` bigint(20) NOT NULL,
  `v_no` bigint(20) NOT NULL,
  `d_no` bigint(20) NOT NULL,
  `from_date` text NOT NULL,
  `to_date` text NOT NULL,
  `from_place` text NOT NULL,
  `to_place` text NOT NULL,
  `distance` bigint(20) NOT NULL,
  `order_status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`c_no`, `c_name`, `c_addr`, `c_phone_no`, `front_party_name`, `front_party_addr`, `front_party_phone_no`, `i_name`, `quantity`, `rate`, `total_amount`, `v_no`, `d_no`, `from_date`, `to_date`, `from_place`, `to_place`, `distance`, `order_status`) VALUES
(1, 'Vinit M', 'Nashik', '1234567890', 'Vinit Shop', 'Nashik', '2314567890', 'Glossary', 150, 10, 1500, 11, 12, '7-4-2023', '8-4-2023', 'Nashik', 'Nashik', 100, 'Out For Delivery'),
(5, 'a', 'a', '12', 'a', 'a', '2', 'd', 2, 3, 6, 2, 2, '7-4-2023', '8-4-2023', 'a', 'a', 4, 'Out For Delivery'),
(6, 'q', 'q', '1', 'ws', '1w', '1', '2w', 34, 2, 68, 1, 1, '7-4-2023', '8-4-2023', 'q', '1w', 45, 'Out For Delivery'),
(7, 'devnjgut', 'r4r', '6567', 'jgjh', 'bjk', '7578', 'hiu', 675, 65, 43875, 7, 2, '7-4-2023', '12-12-12', 'r4r', 'bjk', 234, 'Out For Delivery'),
(8, 'Nikita Mahajan', 'viman Nagar,Pune.', '6734998287', 'Pooja', 'Mehrun,Jalgaon.', '6744583700', 'Fruits', 1000, 1000, 1000000, 11, 4, '14-4-2023', '20-4-2023', 'viman Nagar,Pune.', 'Mehrun,Jalgaon.', 650, 'Out For Delivery');

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `d_no` int(11) NOT NULL,
  `d_name` text NOT NULL,
  `d_addr` text NOT NULL,
  `d_phone_no` text NOT NULL,
  `d_license_no` text NOT NULL,
  `d_available` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`d_no`, `d_name`, `d_addr`, `d_phone_no`, `d_license_no`, `d_available`) VALUES
(1, 'Pratik', 'Nashik', '9876543210', 'ABC123DEF', 'yes'),
(2, 'Devesh', 'Jalgaon', '9876543210', 'ABCsdfdf', 'yes'),
(3, 'Akshay', 'Jalgaon', '8765432190', 'PQR333ABC', 'yes'),
(4, 'Lokesh', 'Jalgaon', '8765432190', 'AAA123GRD', 'no'),
(5, 'Kushal', 'Jalgaon', '1234567890', 'XYZ456QWE', 'yes'),
(6, 'Shubham', 'Jalgaon', '8906543217', 'QWE567POI', 'yes'),
(7, 'Devendra', 'Nashik', '6789054321', 'JRO789LKJ', 'yes'),
(8, 'Mahendra', 'Jalgaon', '1245678902', 'ZXC567BNM', 'yes'),
(9, 'Vivek S', 'Nashik', '6789067890', 'MHU123UYT', 'yes'),
(11, 'Raju', 'Jalgaon', '8765876587', 'BNBVF234F', 'yes'),
(12, 'Mahi Bhosale', 'Mumbai', '678340987', 'AY234Z', 'yes');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `v_no` bigint(20) NOT NULL,
  `v_name` text NOT NULL,
  `capacity` bigint(11) NOT NULL,
  `puc_no` text NOT NULL,
  `v_available` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`v_no`, `v_name`, `capacity`, `puc_no`, `v_available`) VALUES
(1, 'Box Truck', 1000, '1ABC2345', 'yes'),
(2, 'Pick-up truck', 500, 'ZXCVTG23NP', 'yes'),
(3, 'Pick-up truck', 700, 'WERTASC71Q', 'yes'),
(4, 'Dumper truck', 10000, 'MNBVCXZ45Q', 'yes'),
(5, 'Dumper truck', 1000, 'QWERTYUI51P', 'yes'),
(6, 'Small truck', 400, 'ASDFGHJK99L', 'yes'),
(7, 'Taxi', 300, 'ASDFGHJN44L', 'yes'),
(10, 'Box-Truck', 900, 'CFDS665BM', 'yes'),
(11, 'Truck', 1000, 'ZXT34W45', 'no');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD UNIQUE KEY `dr_no` (`dr_no`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD KEY `c_no` (`c_no`);

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`d_no`);

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`v_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `c_no` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
