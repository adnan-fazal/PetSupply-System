# 🐾 PetSupply-System

**A comprehensive Java Swing-based Pet Shop Management System with role-based access control and intuitive GUI interface.**

## 📋 Overview

The PetSupply-System is a desktop application designed to streamline pet shop operations through a user-friendly graphical interface. Built with Java Swing, this system provides separate dashboards for managers and cashiers, enabling efficient inventory management, transaction processing, and user account administration.

## ✨ Key Features

### 🔐 **Authentication System**
- Secure login functionality with role-based access
- Support for Manager and Cashier user roles
- Password visibility toggle for enhanced user experience
- Account creation and management capabilities

### 👨‍💼 **Manager Dashboard**
- **Inventory Management**: View and manage pet supplies catalog
- **Transaction Monitoring**: Track all purchase transactions and sales history
- **User Management**: Create cashier accounts and view all created accounts
- **Comprehensive Reporting**: Access detailed transaction reports

### 💰 **Cashier Dashboard**
- **Inventory Access**: View available pet supplies and stock
- **Transaction Processing**: Create and manage customer transactions
- **Streamlined Interface**: Simplified workflow for daily operations

### 🛍️ **Pet Supplies Management**
- Extensive catalog of **20+ pet supplies** including:
  - Pet Food, Toys, and Treats
  - Grooming supplies (Shampoo, Brushes, Grooming Kits)
  - Pet accessories (Collars, Leashes, Harnesses)
  - Pet care items (Beds, Carriers, Bowls)
  - Specialized products (Bird Cages, Fish Tanks, Cat Litter)
- Interactive selection system with checkboxes
- Real-time purchase processing

## 🛠️ Technical Specifications

- **Language**: Java
- **GUI Framework**: Java Swing
- **Architecture**: Object-Oriented Design with modular components
- **File Structure**: Organized with separate handler classes for different functionalities
- **Authentication**: File-based user credential management

## 📁 Project Structure

PetSupply-System/
├── src/com/pawshop/
│ ├── PawPetShopPortal.java # Main application class
│ ├── Authentication.java # User authentication handler
│ ├── AdminHandler.java # Admin-specific operations
│ ├── FileHandler.java # File operations management
│ ├── PetSuppliesHandler.java # Inventory management
│ ├── TransactionHandler.java # Transaction processing
│ └── Main.java # Application entry point
├── resources/images/ # GUI background images and icons
├── cashier details.txt # Cashier account information
└── manager details.txt # Manager account information

text

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- IDE supporting Java (IntelliJ IDEA, Eclipse, NetBeans)

### Installation & Setup
1. **Clone the repository**:
git clone https://github.com/adnan-fazal/PetSupply-System.git

text

2. **Navigate to project directory**:
cd PetSupply-System

text

3. **Compile and run**:
javac src/com/pawshop/*.java
java -cp src com.pawshop.Main

text

## 👥 User Roles & Access

### Manager Capabilities
- Complete system administration
- Inventory management and viewing
- Transaction history and reporting
- Cashier account creation and management
- Full access to all system features

### Cashier Capabilities
- Inventory viewing and browsing
- Customer transaction processing
- Basic system operations
- Restricted administrative access

## 🖼️ User Interface

The application features a visually appealing interface with:
- **Custom background images** for each dashboard and dialog
- **Intuitive navigation** between different system modules  
- **Professional styling** with proper color schemes and layouts
- **Responsive design** elements for optimal user experience

## 🔧 Core Components

| Component | Purpose |
|-----------|---------|
| **Authentication** | User login, role verification, account management |
| **AdminHandler** | Manager-specific operations and controls |
| **PetSuppliesHandler** | Inventory management and product catalog |
| **TransactionHandler** | Purchase processing and sales tracking |
| **FileHandler** | Data persistence and file operations |

## 📊 Features Highlight

- **Real-time transaction processing**
- **Comprehensive inventory catalog** with 20+ items
- **Role-based dashboard customization**
- **Secure authentication system**
- **Transaction history tracking**
- **User account management**
- **Professional GUI with custom graphics**

## 🤝 Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues for any improvements or bug fixes.

## 📄 License

This project is available for educational and personal use.

## 📞 Contact

**Developer**: Adnan Fazal  
**Repository**: [PetSupply-System](https://github.com/adnan-fazal/PetSupply-System)

---
*Built with ❤️ using Java Swing for efficient pet shop management*
