<?php

//  define('SHOW_VARIABLES', 1);
//  define('DEBUG_LEVEL', 1);

//  error_reporting(E_ALL ^ E_NOTICE);
//  ini_set('display_errors', 'On');

set_include_path('.' . PATH_SEPARATOR . get_include_path());


include_once dirname(__FILE__) . '/' . 'components/utils/system_utils.php';
include_once dirname(__FILE__) . '/' . 'components/mail/mailer.php';
include_once dirname(__FILE__) . '/' . 'components/mail/phpmailer_based_mailer.php';
require_once dirname(__FILE__) . '/' . 'database_engine/mysql_engine.php';

//  SystemUtils::DisableMagicQuotesRuntime();

SystemUtils::SetTimeZoneIfNeed('Asia/Kuwait');

function GetGlobalConnectionOptions()
{
    return
        array(
          'server' => 'localhost',
          'port' => '3306',
          'username' => 'root',
          'database' => 'carfinal',
          'client_encoding' => 'utf8'
        );
}

function HasAdminPage()
{
    return false;
}

function HasHomePage()
{
    return true;
}

function GetHomeURL()
{
    return 'index.php';
}

function GetHomePageBanner()
{
    return '';
}

function GetPageGroups()
{
    $result = array();
    $result[] = array('caption' => 'Default', 'description' => '');
    return $result;
}

function GetPageInfos()
{
    $result = array();
    $result[] = array('caption' => 'Cars', 'short_caption' => 'Cars', 'filename' => 'cars.php', 'name' => 'cars', 'group_name' => 'Default', 'add_separator' => true, 'description' => '');
    $result[] = array('caption' => 'Failer', 'short_caption' => 'Failer', 'filename' => 'failer.php', 'name' => 'failer', 'group_name' => 'Default', 'add_separator' => true, 'description' => '');
    $result[] = array('caption' => 'Failuer Car', 'short_caption' => 'Failuer Car', 'filename' => 'failuer_car.php', 'name' => 'failuer_car', 'group_name' => 'Default', 'add_separator' => true, 'description' => '');
    $result[] = array('caption' => 'Parking', 'short_caption' => 'Parking', 'filename' => 'parking.php', 'name' => 'parking', 'group_name' => 'Default', 'add_separator' => true, 'description' => '');
    $result[] = array('caption' => 'Parking Car', 'short_caption' => 'Parking Car', 'filename' => 'parking_car.php', 'name' => 'parking_car', 'group_name' => 'Default', 'add_separator' => true, 'description' => '');
    $result[] = array('caption' => 'Payment', 'short_caption' => 'Payment', 'filename' => 'payment.php', 'name' => 'payment', 'group_name' => 'Default', 'add_separator' => true, 'description' => '');
    $result[] = array('caption' => 'Rental', 'short_caption' => 'Rental', 'filename' => 'rental.php', 'name' => 'rental', 'group_name' => 'Default', 'add_separator' => true, 'description' => '');
    $result[] = array('caption' => 'User', 'short_caption' => 'User', 'filename' => 'user.php', 'name' => 'user', 'group_name' => 'Default', 'add_separator' => true, 'description' => '');
    $result[] = array('caption' => 'Userbalance', 'short_caption' => 'Userbalance', 'filename' => 'userbalance.php', 'name' => 'userbalance', 'group_name' => 'Default', 'add_separator' => true, 'description' => '');
    $result[] = array('caption' => 'Usercard', 'short_caption' => 'Usercard', 'filename' => 'usercard.php', 'name' => 'usercard', 'group_name' => 'Default', 'add_separator' => true, 'description' => '');
    $result[] = array('caption' => 'Userstatus', 'short_caption' => 'Userstatus', 'filename' => 'userstatus.php', 'name' => 'userstatus', 'group_name' => 'Default', 'add_separator' => true, 'description' => '');
    return $result;
}

function GetPagesHeader()
{
    return
        '';
}

function GetPagesFooter()
{
    return
        '';
}

function ApplyCommonPageSettings(Page $page, Grid $grid)
{
    $page->SetShowUserAuthBar(false);
    $page->setShowNavigation(true);
    $page->OnCustomHTMLHeader->AddListener('Global_CustomHTMLHeaderHandler');
    $page->OnGetCustomTemplate->AddListener('Global_GetCustomTemplateHandler');
    $page->OnGetCustomExportOptions->AddListener('Global_OnGetCustomExportOptions');
    $page->getDataset()->OnGetFieldValue->AddListener('Global_OnGetFieldValue');
    $page->getDataset()->OnGetFieldValue->AddListener('OnGetFieldValue', $page);
    $grid->BeforeUpdateRecord->AddListener('Global_BeforeUpdateHandler');
    $grid->BeforeDeleteRecord->AddListener('Global_BeforeDeleteHandler');
    $grid->BeforeInsertRecord->AddListener('Global_BeforeInsertHandler');
    $grid->AfterUpdateRecord->AddListener('Global_AfterUpdateHandler');
    $grid->AfterDeleteRecord->AddListener('Global_AfterDeleteHandler');
    $grid->AfterInsertRecord->AddListener('Global_AfterInsertHandler');
}

function GetAnsiEncoding() { return 'windows-1256'; }

function Global_OnGetCustomPagePermissionsHandler(Page $page, PermissionSet &$permissions, &$handled)
{

}

function Global_CustomHTMLHeaderHandler($page, &$customHtmlHeaderText)
{

}

function Global_GetCustomTemplateHandler($type, $part, $mode, &$result, &$params, CommonPage $page = null)
{

}

function Global_OnGetCustomExportOptions($page, $exportType, $rowData, &$options)
{

}

function Global_OnGetFieldValue($fieldName, &$value, $tableName)
{

}

function Global_GetCustomPageList(CommonPage $page, PageList $pageList)
{

}

function Global_BeforeInsertHandler($page, &$rowData, $tableName, &$cancel, &$message, &$messageDisplayTime)
{

}

function Global_BeforeUpdateHandler($page, $oldRowData, &$rowData, $tableName, &$cancel, &$message, &$messageDisplayTime)
{

}

function Global_BeforeDeleteHandler($page, &$rowData, $tableName, &$cancel, &$message, &$messageDisplayTime)
{

}

function Global_AfterInsertHandler($page, $rowData, $tableName, &$success, &$message, &$messageDisplayTime)
{

}

function Global_AfterUpdateHandler($page, $oldRowData, $rowData, $tableName, &$success, &$message, &$messageDisplayTime)
{

}

function Global_AfterDeleteHandler($page, $rowData, $tableName, &$success, &$message, &$messageDisplayTime)
{

}

function GetDefaultDateFormat()
{
    return 'Y-m-d';
}

function GetFirstDayOfWeek()
{
    return 0;
}

function GetPageListType()
{
    return PageList::TYPE_SIDEBAR;
}

function GetNullLabel()
{
    return null;
}

function UseMinifiedJS()
{
    return true;
}

function GetOfflineMode()
{
    return false;
}

function GetInactivityTimeout()
{
    return 0;
}

function GetMailer()
{

}

function sendMailMessage($recipients, $messageSubject, $messageBody, $attachments = '', $cc = '', $bcc = '')
{

}

function createConnection()
{
    $connectionOptions = GetGlobalConnectionOptions();
    $connectionOptions['client_encoding'] = 'utf8';

    $connectionFactory = MySqlIConnectionFactory::getInstance();
    return $connectionFactory->CreateConnection($connectionOptions);
}
