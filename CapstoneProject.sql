create database Capstone;

CREATE TABLE STUDENT (
    Stud_UniversityID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Stud_FirstName VARCHAR(40) NOT NULL,
    Stud_LastName VARCHAR(40) NOT NULL,
    Stud_EmailAdress VARCHAR(30) NOT NULL,
    EnrollmentDate DATE NOT NULL,
    DegreeEarned VARCHAR(50) DEFAULT NULL,
    GraduationDate DATE NOT NULL,
    DormName VARCHAR(4) NOT NULL,
    DormPhoneNumber VARCHAR(20) DEFAULT NULL,
    DormRoomNumber INT NOT NULL
);



CREATE TABLE ADVISOR (
    Fac_UniversityID INT AUTO_INCREMENT KEY NOT NULL,
    Fac_FirstName VARCHAR(40) NOT NULL,
    Fac_LastName VARCHAR(40) NOT NULL,
    Fac_EmailAddress VARCHAR(30) NOT NULL,
    Department VARCHAR(3) NOT NULL,
    OfficeBuildingName VARCHAR(4) NOT NULL,
    OfficeBuildingPhoneNumber VARCHAR(20) DEFAULT NULL,
    OfficeBuildingRoomNumber INT NOT NULL
);


CREATE TABLE ALUMNI (
    Alum_FormerStudentNumber INT PRIMARY KEY NOT NULL,
    Alum_FirstName VARCHAR(40) NOT NULL,
    Alum_LastName VARCHAR(40) NOT NULL,
    Alum_EmailAddress VARCHAR(30) NOT NULL,
    HomeAddress VARCHAR(20) NOT NULL,
    HomeCity VARCHAR(10) NOT NULL,
    HomeState VARCHAR(2) NOT NULL,
    HomeZIP INT NOT NULL,
    PhoneNumber VARCHAR(20) NOT NULL
);

CREATE TABLE ASSIGNMENT (
    Fac_UniversityID INT NOT NULL,
    Stud_UniversityID INT NOT NULL,
    AssignmentDate DATE NOT NULL,
    EndDate DATE NOT NULL,
    PRIMARY KEY (Fac_UniversityID , Stud_UniversityID),
    FOREIGN KEY (Fac_UniversityID)
        REFERENCES ADVISOR (Fac_UniversityID)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (Stud_UniversityID)
        REFERENCES STUDENT (Stud_UniversityID)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE MENTOR (
    Ment_EmailAddress VARCHAR(30) NOT NULL PRIMARY KEY,
    Ment_FirstName VARCHAR(40) NOT NULL,
    Ment_LastName VARCHAR(40) NOT NULL,
    CompanyName VARCHAR(15) NOT NULL,
    CompanyPhoneNumber VARCHAR(20) NOT NULL,
    CompanyAddress VARCHAR(30) NOT NULL,
    CompanyCity VARCHAR(10) NOT NULL,
    CompanyState VARCHAR(2) NOT NULL,
    CompanyZIPCode VARCHAR(5) NOT NULL,
    Alum_FormerStudentNumber INT DEFAULT NULL,
    FOREIGN KEY (Alum_FormerStudentNumber)
        REFERENCES ALUMNI (Alum_FormerStudentNumber)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE SIGNING (
    Stud_UniversityID INT NOT NULL,
    Ment_EmailAddress VARCHAR(30) NOT NULL,
    PRIMARY KEY (Ment_EmailAddress , Stud_UniversityID),
    SigningDate DATE NOT NULL,
	EndDate DATE NOT NULL,
    FOREIGN KEY (Stud_UniversityID)
        REFERENCES STUDENT (Stud_UniversityID)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (Ment_EmailAddress)
        REFERENCES MENTOR (Ment_EmailAddress)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE COORDINATE (
    Fac_UniversityID INT NOT NULL,
    Ment_EmailAddress VARCHAR(30) NOT NULL,
    MeetingDate DATE NOT NULL,
    EndDate DATE NOT NULL,
    PRIMARY KEY (Ment_EmailAddress , Fac_UniversityID),
    FOREIGN KEY (Fac_UniversityID)
        REFERENCES ADVISOR (Fac_UniversityID)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (Ment_EmailAddress)
        REFERENCES MENTOR (Ment_EmailAddress)
        ON UPDATE CASCADE ON DELETE CASCADE
);
