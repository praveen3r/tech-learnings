import React from 'react'
import './custom.css';
import styles from './custom.module.css';

function ModuleStyling() {
    return (
        <div>
            <p className='moduleStyle'>Global style</p>
            <p className={styles.moduleStyle}>Global style override</p>
        </div>
    )
}

export default ModuleStyling
