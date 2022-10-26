import React from "react";
import { Container, Nav, Navbar } from "react-bootstrap";
import { Link } from "react-router-dom";

function NavMenu() {
  return (
    
    <Navbar bg="light" expand="lg" style={{marginBottom: 20}}>
      <Container style={{marginLeft: 20}}>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
          <Link to="/dashboard">Home</Link>
          <Link to="/search" style={{paddingLeft: 20}}>Search</Link>
          <Link to="/download" style={{paddingLeft: 20}}>Download</Link>
            
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default NavMenu;
