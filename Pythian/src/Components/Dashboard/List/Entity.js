import React from 'react';
import Unit from './Unit'
import Styled from 'styled-components'
export default function componentName({image,items,itemFunc}) {

  return (

    <EntityWrapper className="col-sm-6 my-1 mx-auto">
                    <div className="input-group">
                        <div className="input-group-prepend">
                            <div className="input-group-text"><img src={"/Icon/Svg/"+image+".svg"} width="30px" alt=""></img></div>
                        </div>
                        <label type="text" className="h-30 bg-transparent form-control overflow-auto"> 
                                <ul className="list-inline element_inline_list d-flex">
                                    {
                                        items.map((val,i)=>{
                                            return <Unit key={i} val={val} itemFunc={itemFunc}></Unit>        
                                        })
                                    }
                                    </ul>
                        </label>
            </div>
    </EntityWrapper>
  );
}

const EntityWrapper = Styled.div`
{
    margin:auto;
}
.h-30{
    height:50px
}
.uppercase{
    text-transform:uppercase;
}
`;
