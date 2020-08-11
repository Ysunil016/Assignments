import styled from 'styled-components'

const NavButton = styled.button`
    text-transform:capatalize;
    font-size:1.4rem;
    background:transparent;
    border: 0.05rem solid var(--light_blue);
    border-color:${props=>props.cart?"var(--main_yellow);":"var(--light_blue);"};
    color:${props=>props.cart?"var(--main_yellow);":"var(--light_blue);"};
    border-radius:0.5rem;
    padding: 0.2rem 0.5rem;
    cursor:pointer;
    margin:0.2rem 0.5rem 0.2rem 0;
    transition:all 0.5 ease-n-out;
    &:hover{
        background:${props=>props.cart?"var(--main_yellow);":"var(--light_blue);"};
        color:var(--main_blue);   
    }
    &:focus{
        outline:none
    }
`;


export {NavButton}