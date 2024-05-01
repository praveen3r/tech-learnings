import { IconButton, TableCell, TableRow } from '@mui/material';
import React from 'react';
import { FaAngleDown, FaAngleUp } from 'react-icons/fa';

const ExpandableTableRow = ({ children, expandComponent, ...otherProps }: any) => {
    const [isExpanded, setIsExpanded] = React.useState(false);
  
    return (
      <>
        <TableRow {...otherProps}>
          <TableCell padding="checkbox">
            <IconButton onClick={() => setIsExpanded(!isExpanded)}>
              {isExpanded ? <FaAngleDown /> : <FaAngleUp />}
            </IconButton>
          </TableCell>
          {children}
        </TableRow>
        {isExpanded && (
          <TableRow>
            <TableCell padding="checkbox" />
            {expandComponent}
          </TableRow>
        )}
      </>
    );
  };

export default ExpandableTableRow