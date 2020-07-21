import React from 'react';
import Styled from 'styled-components'

export default function componentName({val,itemFunc}) {
  return (
    
    <li className="list-inline-item">
      <UnitWrapper>
        <button onClick={()=>itemFunc(val.name)} className="btn btm-sm" style={{backgroundColor:val.color}}>
        {val.name}
        </button>
      </UnitWrapper>
      </li>
  );
}

const UnitWrapper = Styled.div`
:hover button{
  background-color:var(--dark_1) !important;
  color:white;
}
`;

