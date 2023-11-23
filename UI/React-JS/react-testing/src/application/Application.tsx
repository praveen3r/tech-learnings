import React from "react";

const Application = () => {
  return (
    <>
      <h1>Job application form</h1>
      <h2>Section 1</h2>
      <p>All fields are mandatory</p>
      <span title="close">close</span>
      <div data-testid="test">Custom HTML attribute</div>
      <form>
        <div>
          <label htmlFor="name">Name</label>
          <input
            type="text"
            id="name"
            placeholder="enter name"
            value="Demo"
            onChange={() => {}}
          />
        </div>
        <div>
          <label htmlFor="bio">Bio</label>
          <textarea id="bio" name="bio" />
        </div>
        <div>
          <label htmlFor="country">Country</label>
          <select id="country">
            <option>Test1</option>
            <option>Test1</option>
          </select>
        </div>
        <div>
          <label htmlFor="terms">
            <input type="checkbox" id="terms" />I agree to Terms and conditions
          </label>
        </div>
        <div>
          <button type="button">Submit</button>
        </div>
      </form>
    </>
  );
};

export default Application;
