<?php if ($this->_tpl_vars['DataGrid']['SelectionFilter']->isActive()): ?>
<div class="filter-status-value filter-status-value-selection-filter" title="<?php echo $this->_tpl_vars['DataGrid']['SelectionFilter']->toString(); ?>
">
    <i class="filter-status-value-icon icon-selection-filter"></i>
    <span class="filter-status-value-expr"><?php echo $this->_tpl_vars['DataGrid']['SelectionFilter']->toString(); ?>
</span>
    <div class="filter-status-value-controls">
        <a href="#" class="js-reset-selection-filter" title="<?php echo $this->_tpl_vars['Captions']->GetMessageString('ResetFilter'); ?>
">
            <i class="icon-remove"></i>
        </a>
    </div>
</div>
<?php endif; ?>