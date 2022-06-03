import { should } from "chai"

describe('Invalid form', () => {
  it('Should not login if form is invalid', () => {
    cy.visit('/');
    cy.url().should('includes', 'login');
    cy.get('[formControlName="email"]').type('nananananana BATMAN');
    cy.get('[formControlName="password"]').type('niesamowita gruszka 1');
    cy.get('button').should('be.disabled')
    cy.url().should('not.includes', 'dashboard');
  })
})

describe('Invalid email', () => {
  it('Should not login if user does not exist', () => {
    cy.visit('/');
    cy.url().should('includes', 'login');
    cy.get('[formControlName="email"]').type('wspanialy@grzebacz.com');
    cy.get('[formControlName="password"]').type('niesamowita gruszka 1');
    cy.get('button').click();
    cy.url().should('not.includes', 'dashboard');
  })
})

describe('User register', () => {
  it('Should register new user', () => {
    cy.visit('/');
    cy.url().should('includes', 'login');
    cy.get('a[href*="/pages/auth/register"]').click();
    cy.url().should('includes', 'register');
    cy.get('[formControlName="name"]').type('Marek');
    cy.get('[formControlName="surname"]').type('Potoczny');
    cy.get('[formControlName="email"]').type('marek.potoczny@example.com');
    cy.get('[formControlName="password"]').type('123');
    cy.get('[formControlName="passwordConfirm"]').type('123');
    cy.get('button').click();
    cy.url().should('includes', 'dashboard');
  })
})

describe('Correct login', () => {
  it('Should redirect to dashboard', () => {
    cy.visit('/');
    cy.url().should('includes', 'login');
    cy.get('[formControlName="email"]').type('marek.potoczny@example.com');
    cy.get('[formControlName="password"]').type('123');
    cy.get('button').click();
    cy.url().should('includes', 'dashboard');
  })
})


