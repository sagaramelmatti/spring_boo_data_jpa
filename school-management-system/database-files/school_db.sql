-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 04, 2024 at 10:27 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `school_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `standard_details`
--

CREATE TABLE `standard_details` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `standard_details`
--

INSERT INTO `standard_details` (`id`, `name`) VALUES
(1, 'Class-5'),
(4, 'Class-8');

-- --------------------------------------------------------

--
-- Table structure for table `standard_subject_details`
--

CREATE TABLE `standard_subject_details` (
  `subject_id` int(11) NOT NULL,
  `standard_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `standard_subject_mapping`
--

CREATE TABLE `standard_subject_mapping` (
  `id` int(11) NOT NULL,
  `standard_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `standard_subject_mapping`
--

INSERT INTO `standard_subject_mapping` (`id`, `standard_id`, `subject_id`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `standard_teacher_mapping`
--

CREATE TABLE `standard_teacher_mapping` (
  `id` int(11) NOT NULL,
  `standard_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `standard_teacher_mapping`
--

INSERT INTO `standard_teacher_mapping` (`id`, `standard_id`, `teacher_id`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `student_details`
--

CREATE TABLE `student_details` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `age` int(11) NOT NULL,
  `standard_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_details`
--

INSERT INTO `student_details` (`id`, `name`, `age`, `standard_id`) VALUES
(1, 'Sanvi', 10, 1);

-- --------------------------------------------------------

--
-- Table structure for table `subject_details`
--

CREATE TABLE `subject_details` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subject_details`
--

INSERT INTO `subject_details` (`id`, `name`) VALUES
(1, 'Mathematics'),
(2, 'Social Science');

-- --------------------------------------------------------

--
-- Table structure for table `teacher_details`
--

CREATE TABLE `teacher_details` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `contact_number` varchar(12) NOT NULL,
  `education` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teacher_details`
--

INSERT INTO `teacher_details` (`id`, `name`, `contact_number`, `education`) VALUES
(1, 'Rahul', '9999999999', 'BE'),
(2, 'Saurav', '222222222', 'MCA');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `standard_details`
--
ALTER TABLE `standard_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `standard_subject_details`
--
ALTER TABLE `standard_subject_details`
  ADD KEY `FK54g47aa2c8cl4ijqv4ralgc7r` (`standard_id`),
  ADD KEY `FK5gmfxut0iad3e8qklu2nw0xpr` (`subject_id`);

--
-- Indexes for table `standard_subject_mapping`
--
ALTER TABLE `standard_subject_mapping`
  ADD PRIMARY KEY (`id`),
  ADD KEY `standard_id` (`standard_id`),
  ADD KEY `subject_id` (`subject_id`);

--
-- Indexes for table `standard_teacher_mapping`
--
ALTER TABLE `standard_teacher_mapping`
  ADD PRIMARY KEY (`id`),
  ADD KEY `standard_id` (`standard_id`),
  ADD KEY `teacher_id` (`teacher_id`);

--
-- Indexes for table `student_details`
--
ALTER TABLE `student_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `standard_id` (`standard_id`);

--
-- Indexes for table `subject_details`
--
ALTER TABLE `subject_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teacher_details`
--
ALTER TABLE `teacher_details`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `standard_details`
--
ALTER TABLE `standard_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `standard_subject_mapping`
--
ALTER TABLE `standard_subject_mapping`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `standard_teacher_mapping`
--
ALTER TABLE `standard_teacher_mapping`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `student_details`
--
ALTER TABLE `student_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `subject_details`
--
ALTER TABLE `subject_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `teacher_details`
--
ALTER TABLE `teacher_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `standard_subject_details`
--
ALTER TABLE `standard_subject_details`
  ADD CONSTRAINT `FK54g47aa2c8cl4ijqv4ralgc7r` FOREIGN KEY (`standard_id`) REFERENCES `standard_details` (`id`),
  ADD CONSTRAINT `FK5gmfxut0iad3e8qklu2nw0xpr` FOREIGN KEY (`subject_id`) REFERENCES `subject_details` (`id`);

--
-- Constraints for table `standard_subject_mapping`
--
ALTER TABLE `standard_subject_mapping`
  ADD CONSTRAINT `standard_subject_mapping_ibfk_1` FOREIGN KEY (`standard_id`) REFERENCES `standard_details` (`id`),
  ADD CONSTRAINT `standard_subject_mapping_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subject_details` (`id`);

--
-- Constraints for table `standard_teacher_mapping`
--
ALTER TABLE `standard_teacher_mapping`
  ADD CONSTRAINT `standard_teacher_mapping_ibfk_1` FOREIGN KEY (`standard_id`) REFERENCES `standard_details` (`id`),
  ADD CONSTRAINT `standard_teacher_mapping_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `teacher_details` (`id`);

--
-- Constraints for table `student_details`
--
ALTER TABLE `student_details`
  ADD CONSTRAINT `student_details_ibfk_1` FOREIGN KEY (`standard_id`) REFERENCES `standard_details` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
