import React from 'react';

export default function componentName({key_val,value}) {
  return (
    <>
    <div className="col-sm-6 my-1">
    {/* <label className="sr-only">Username</label> */}
          <div className="input-group">
              <div className="input-group-prepend">
              <div className="input-group-text uppercase">{key_val}</div>
              </div>
              <label type="text" className="text-center form-control"> {value} </label>
          </div>
    </div>
    </>
  );
}
